


# ktlintCheck
lint:
	./gradlew ktlintCheck

# Run ktlintFormat
format:
	./gradlew ktlintFormat

# Run Unit Tests
test:
	./gradlew test

# Run UI tests on gradle managed phone device
uiTestPhone:
	./gradlew pixel2api30DebugAndroidTest

# Run UI tests on gradle managed tablet device
uiTestTablet:
	./gradlew nexus9api30DebugAndroidTest

# Run UI tests on gradle managed phone and tablet devices
uiTestGroup:
	./gradlew phoneAndTabletGroupDebugAndroidTest