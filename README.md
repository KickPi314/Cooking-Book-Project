# CookYourBooks — Cooking Book App

![CookYourBooks Project Overview](https://github.com/user-attachments/assets/162212b9-00b9-4f2f-96bf-6eb0fb1c49ca)

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
---

## Getting Started

### Prerequisites
- A recent **JDK** installed (Java 17+ recommended)
- Gradle wrapper is included (`./gradlew`), so you don’t need Gradle installed separately.

### Build
```bash
./gradlew build
```

### Run
Depending on how your `CookYourBooksApp` is configured, you can typically run via:

```bash
./gradlew run
```

> If you run into JavaFX runtime issues, confirm your JDK/JavaFX setup matches the project’s Gradle configuration.

---

## Data & Recipes

- The main library file is: **`cyb-library.json`**
- Additional recipe content and examples may live under:
  - `sample-recipes/`

If you want to reset your environment, start by backing up and/or replacing `cyb-library.json`.

---

## Testing

```bash
./gradlew test
```
