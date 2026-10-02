# Agent Documentation & Engineering Log

## Project Context
- **Name**: FGP Demo Compose (Jetpack Compose Learning App - Social Media Theme)
- **Framework**: Jetpack Compose, Material 3, Kotlin Coroutines, ViewModel.
- **Goal**: Provide an interactive 12-step guided tour teaching core Compose components through a social media application theme.

## Engineering Decisions & Fixes
1. **Modular Architecture**: Separated the codebase cleanly into `models`, `viewmodels`, `components`, `screens`, and `ui.theme` packages to ensure maintainability and separation of concerns.
2. **State & Tour Progression**: `MainActivity` manages the current tour step (1 through 12) along with global theme toggling (Dark/Light mode), allowing users to navigate forward, backward, or explore components interactively.
3. **Bug Resolution**: 
   - Fixed an initial `ArrayIndexOutOfBoundsException` in `Models.kt` where `DummyData.stories` attempted to access `users[5]` while `users` only contained 5 elements (indices 0 to 4).
   - Added missing Material icons and ViewModel Compose dependencies in `build.gradle.kts`.

## Verification Status
- **Gradle Build**: Successfully compiled (`app:assembleDebug`).
- **Runtime**: Deployed and tested on connected Android device/emulator.
