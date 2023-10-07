/**
 * Object to store test dependencies.
 * @author Taji Abdullah
 * */
object TestDependency {
    object Version {
        const val jUnit = "4.13.2"
        const val testNG = "6.9.6"
        const val androidJUnit = "1.1.5"
        const val espressoCore = "3.5.1"
        const val composeUiTest = "ui-test-junit4"
        const val mockWebServer = "4.9.1"
        const val testCoroutines = "1.6.4"
        const val testRunner = "1.5.2"
    }

    const val jUnit = "junit:junit:${Version.jUnit}"
    const val testNg = "org.testng:testng:${Version.testNG}"
    const val androidJUnit = "androidx.test.ext:junit:${Version.androidJUnit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Version.espressoCore}"
    const val composeBom = Dependency.composeBom
    const val composeUi = "androidx.compose.ui:${Version.composeUiTest}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Version.mockWebServer}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.testCoroutines}"
    const val room = "androidx.room:room-testing:${Dependency.Version.room}"
    const val testRunner = "androidx.test:runner:${Version.testRunner}"
    const val HILT_COMPILER = Dependency.HILT_COMPILER
}
