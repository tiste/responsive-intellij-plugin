<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# responsive-intellij-plugin Changelog

## Unreleased

## 0.1.5 - 2023-04-12

### Added
- Update `pluginUntilBuild` to include `231.*`

## 0.1.4

### Added
- Update `pluginUntilBuild` to include `223.*`

## 0.1.3

### Added
- Remove `pluginUntilBuild` to include all future versions

## 0.1.2

### Added
- Update `pluginUntilBuild` to include `221.*`

## 0.1.1

### Removed
- Remove `pluginUntilBuild`

## 0.1.0

### Changed
- Update `platformVersion` to `2021.1.3` for compatibility with Apple M1
- Change since/until build to `211-213.*` (2021.1 - 2021.3)
- Upgrade Gradle Wrapper to `7.4`
- Dependencies - upgrade `org.jetbrains.intellij` to `1.4.0`
- Dependencies (GitHub Actions) - upgrade `JetBrains/qodana-action` to `4.2.5`
- GitHub Actions - fixed duplicated `.zip` extension in artifact file's name of the build flow
- Upgrade Gradle Wrapper to `7.3.3`
- Dependencies - upgrade `org.jetbrains.intellij` to `1.3.1`
- Dependencies - upgrade `org.jetbrains.kotlin.jvm` to `1.6.10`
- Dependencies (GitHub Actions) - upgrade `JetBrains/qodana-action` to `4.2.3`
- Dependencies (GitHub Actions) - upgrade `actions/cache` to `v2.1.7`
- Dependencies - upgrade `org.jetbrains.intellij` to `1.3.0`
- Dependencies - upgrade `org.jetbrains.changelog` to `1.3.1`
- Dependencies - upgrade `org.jetbrains.kotlin.jvm` to `1.6.0`
- Dependencies (GitHub Actions) - upgrade `jtalk/url-health-check-action` to `2`
- Dependencies (GitHub Actions) - upgrade `actions/checkout` to `2.3.5`
- GitHub Actions general performance refactoring
- GitHub Actions - prepare plugin archive content to be archived once
- GitHub Actions - patch changelog only if change notes are provided
- Update `pluginUntilBuild` to include `213.*` (2021.3.*)
- Upgrade Gradle Wrapper to `7.3`

### Fixed
- Fixed passing change notes from `CHANGELOG.md` to the Release Draft
- Fixed passing updated change notes from the Release Draft to `patchChangelog` Gradle task
- Fixed `QODANA_SHOW_REPORT` environment variable resolving for Gradle `6.x`

### Removed
- Removed the `pluginVerifierIdeVersions` configuration to use default IDEs list provided by the `listProductsReleases` task for `runPluginVerifier`
- Removed `platformDownloadSources` from Gradle configuration to use default value
- Removed `updateSinceUntilBuild.set(true)` from Gradle configuration to use default value

### Added
- GitHub Actions: Collect Qodana/Tests/Plugin Verifier results as artifacts
- Plugin Signing
- Qodana integration
- Functional tests
- Compatibility with Java 11
- `Run Qodana` and `Run IDE for UI Tests` run configurations
- Use Gradle `wrapper` task to handle Gradle updates
- JVM compatibility version extracted to `gradle.properties` file
- Suppress `UnusedProperty` inspection for the `kotlin.stdlib.default.dependency` in `gradle.properties`

## 0.0.3

### Removed
- Removed `detekt`/`ktlint` integration

### Changed
- GitHub Actions: Use Java 11
- Update `pluginVerifierIdeVersions` to `2020.3.4, 2021.1.3`
- Change since/until build to `203-212.*`
- Upgrade Gradle Wrapper to `7.1.1`
- Gradle – Changelog plugin configuration update
- Dependencies - upgrade `org.jetbrains.kotlin.jvm` to `1.5.21`
- Dependencies - upgrade `org.jetbrains.changelog` to `1.2.1`
- Dependencies - upgrade `org.jetbrains.intellij` to `1.1.4`

## 0.0.2

### Changed
- Update pluginUntilBuild to last version

## 0.0.1

### Added
- Initial scaffold created from [IntelliJ Platform Plugin Template](https://github.com/JetBrains/intellij-platform-plugin-template)
