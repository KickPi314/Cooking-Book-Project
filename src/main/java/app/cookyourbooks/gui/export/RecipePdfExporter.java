package app.cookyourbooks.gui.export;

import java.io.IOException;
import java.nio.file.Path;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import app.cookyourbooks.model.Ingredient;
import app.cookyourbooks.model.Instruction;
import app.cookyourbooks.model.Recipe;

/** Utility for exporting recipes into a simple PDF layout. */
public final class RecipePdfExporter {

  private static final float MARGIN_X = 50F;
  private static final float BOTTOM_MARGIN = 50F;
  private static final float TITLE_FONT_SIZE = 18F;
  private static final float HEADER_FONT_SIZE = 14F;
  private static final float BODY_FONT_SIZE = 12F;
  private static final float TITLE_SPACING = 28F;
  private static final float HEADER_SPACING = 20F;
  private static final float LINE_SPACING = 16F;
  private static final PDType1Font BOLD_FONT =
      new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);
  private static final PDType1Font REGULAR_FONT =
      new PDType1Font(Standard14Fonts.FontName.HELVETICA);

  private RecipePdfExporter() {
    // Utility class.
  }

  /** Exports the given recipe to a PDF file at the provided output path. */
  public static void exportToPdf(Recipe recipe, Path outputPath) throws IOException {
    try (PDDocument document = new PDDocument()) {
      try (PdfWriteState state = new PdfWriteState(document, PDRectangle.LETTER)) {
        state.ensurePageSpace();
        writeLine(state.contentStream, recipe.getTitle(), BOLD_FONT, TITLE_FONT_SIZE, state.y);
        state.y -= TITLE_SPACING;

        state.ensurePageSpace();
        writeLine(state.contentStream, "Ingredients:", BOLD_FONT, HEADER_FONT_SIZE, state.y);
        state.y -= HEADER_SPACING;

        for (Ingredient ingredient : recipe.getIngredients()) {
          state.ensurePageSpace();
          writeLine(
              state.contentStream, ingredient.getName(), REGULAR_FONT, BODY_FONT_SIZE, state.y);
          state.y -= LINE_SPACING;
        }

        state.y -= 6F;
        state.ensurePageSpace();
        writeLine(state.contentStream, "Steps:", BOLD_FONT, HEADER_FONT_SIZE, state.y);
        state.y -= HEADER_SPACING;

        int instructionNumber = 1;
        for (Instruction instruction : recipe.getInstructions()) {
          state.ensurePageSpace();
          String line = instructionNumber + ". " + instruction.getText();
          writeLine(state.contentStream, line, REGULAR_FONT, BODY_FONT_SIZE, state.y);
          state.y -= LINE_SPACING;
          instructionNumber++;
        }
      }

      document.save(outputPath.toFile());
    }
  }

  private static void writeLine(
      PDPageContentStream contentStream, String text, PDType1Font font, float fontSize, float y)
      throws IOException {
    contentStream.beginText();
    contentStream.setFont(font, fontSize);
    contentStream.newLineAtOffset(MARGIN_X, y);
    contentStream.showText(text);
    contentStream.endText();
  }

  private static final class PdfWriteState implements AutoCloseable {
    private final PDDocument document;
    private final PDRectangle pageSize;
    private PDPageContentStream contentStream;
    private float y;

    private PdfWriteState(PDDocument document, PDRectangle pageSize) throws IOException {
      this.document = document;
      this.pageSize = pageSize;
      startNewPage();
    }

    private void ensurePageSpace() throws IOException {
      if (y < BOTTOM_MARGIN) {
        startNewPage();
      }
    }

    private void startNewPage() throws IOException {
      if (contentStream != null) {
        contentStream.close();
      }
      PDPage page = new PDPage(pageSize);
      document.addPage(page);
      contentStream = new PDPageContentStream(document, page);
      y = page.getMediaBox().getHeight() - MARGIN_X;
    }

    @Override
    public void close() throws IOException {
      if (contentStream != null) {
        contentStream.close();
      }
    }
  }
}
