/**
 * Object to store test dependencies.
 * @author Taji Abdullah
 * */
object TestDependency {
    object Version {
        const val J_UNIT = "4.13.2"
        const val TEST_NG = "6.9.6"
        const val androidJUnit = "1.1.5"
        const val espressoCore = "3.5.1"
        const val composeUiTest = "ui-test-junit4"
        const val mockWebServer = "4.9.1"
        const val testCoroutines = "1.6.4"
        const val testRunner = "1.5.2"
    }

    const val J_UNIT = "junit:junit:${Version.J_UNIT}"
    const val TEST_NG = "org.testng:testng:${Version.TEST_NG}"
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
