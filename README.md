# CookYourBooks — Cooking Book App

CookYourBooks is a full‑stack (app + data + UI) cooking book project that helps you **collect recipes, browse your personal library, and interact with your cookbook through both a GUI and a CLI**.

It’s built as a **Gradle Java application** with a layered architecture (`model`, `repository`, `services`, adapters) and a JavaFX-based interface (FXML + CSS).

---

## Highlights

- **Recipe Library** backed by JSON (`cyb-library.json`)
- **Two ways to use it**
  - **GUI**: JavaFX views (FXML) styled with CSS  
  - **CLI**: command-driven interaction for quick workflows
- **Clean structure** with clear separation of concerns:
  - `model/` — domain objects
  - `repository/` — persistence + storage logic
  - `services/` — business rules / orchestration
  - `adapters/` — integration boundaries
  - `conversion/` — format conversion utilities
  - `exception/` — error types for predictable failures

---

## Tech Stack

- **Language:** Java  
- **Build Tool:** Gradle  
- **UI:** JavaFX (FXML + CSS)  
- **Logging:** Logback (`src/main/resources/logback.xml`)  
- **Data format:** JSON (library stored in `cyb-library.json`)  

---

## Repository Layout

```text
.
├── README.md
├── build.gradle
├── settings.gradle
├── gradlew / gradlew.bat
├── cyb-library.json
├── src/
│   ├── main/
│   │   ├── java/app/cookyourbooks/
│   │   │   ├── CookYourBooksApp.java
│   │   │   ├── CybLibrary.java
│   │   │   ├── adapters/
│   │   │   ├── cli/
│   │   │   ├── conversion/
│   │   │   ├── exception/
│   │   │   ├── gui/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   └── services/
│   │   └── resources/
│   │       ├── fxml/
│   │       ├── css/
│   │       └── logback.xml
│   └── test/
│       ├── java/
│       └── resources/
├── sample-recipes/
├── menu-features/
├── design/
└── config/
```
