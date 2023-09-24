/**
 * Object to store test dependencies.
 * */
object TestDependency {
    const val jUnit = "junit:junit:${Version.jUnit}"
    const val androidJUnit = "androidx.test.ext:junit:${Version.androidJUnit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Version.espressoCore}"
    const val composeBom = Dependency.composeBom
    const val composeUi = "androidx.compose.ui:${Version.composeUiTest}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Version.mockWebServer}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.testCoroutines}"
}