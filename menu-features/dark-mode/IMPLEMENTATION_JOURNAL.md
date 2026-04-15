## 4. Testing & Quality

### Unit tests for the feature
- Added a dedicated dark-mode GUI test file: [src/test/java/app/cookyourbooks/gui/DarkModeGuiTest.java](src/test/java/app/cookyourbooks/gui/DarkModeGuiTest.java).
- The tests cover the default light-mode startup state, toggling dark mode on, toggling it back off, and saving the preference to `java.util.prefs.Preferences`.
- The general GUI navigation suite was kept separate in [src/test/java/app/cookyourbooks/gui/GuiEndToEndExampleTest.java](src/test/java/app/cookyourbooks/gui/GuiEndToEndExampleTest.java) so dark-mode behavior is isolated and easier to explain.

### Accessibility check
- Yes, the dark mode control supports keyboard navigation because it is a standard JavaFX `Button`.
- That means it can be reached with Tab and activated with Enter or Space without any custom key handling.
- The rest of the sidebar navigation also remains keyboard-friendly because it uses standard JavaFX buttons.

### Known limitations
- Theme persistence uses Java `Preferences`, so the saved state is tied to the local user profile/environment rather than a project-managed settings file.
- The dark mode styling is focused on the shared app shell and common controls; individual feature views may still need small visual touch-ups if they introduce custom widgets.
- There is no automated color-contrast or screen-reader audit in the test suite yet, so the accessibility check is currently a manual keyboard-navigation check only.
