# Display targets and descriptions
help:
	@grep -B1 -E "^[a-zA-Z0-9_-]+\:([^\=]|$$)" Makefile \
	 | grep -v -- -- \
	 | sed 'N;s/\n/###/' \
	 | sed -n 's/^#: \(.*\)###\(.*\):.*/\2###\1/p' \
	 | column -t  -s '###'

#: Run ktlintCheck
lint:
	@# Help: Run ktlintCheck
	./gradlew ktlintCheck

#: Run ktlintFormat
format:
	./gradlew ktlintFormat

#: Run Unit Tests
test:
	./gradlew test

#: Run UI tests locally
localUi:
	./gradlew connectedAndroidTest

#: Run unit and connected tests locally
testAll:
	./gradlew test
	./gradlew connectedAndroidTest

#: Run UI tests on gradle managed phone device
uiTestPhone:
	./gradlew pixel2api30DebugAndroidTest

#: Run UI tests on gradle managed tablet device
uiTestTablet:
	./gradlew nexus9api30DebugAndroidTest

#: Run UI tests on gradle managed phone and tablet devices
uiTestGroup:
	./gradlew phoneAndTabletGroupDebugAndroidTest


