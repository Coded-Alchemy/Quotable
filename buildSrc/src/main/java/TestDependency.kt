/**
 * Object to store test dependencies.
 * @author Taji Abdullah
 * */
object TestDependency {
    object Version {
        const val J_UNIT = "4.12"
        const val TEST_NG = "6.9.6"
        const val ANDROID_JUNIT = "1.1.5"
        const val ESPRESSO_CORE = "3.5.1"
        const val COMPOSE_UI_TEST = "ui-test-junit4"
        const val MOCK_WEB_SERVER = "4.9.1"
        const val TEST_COROUTINES = "1.6.4"
        const val TEST_RUNNER = "1.5.2"
        const val CORE_TESTING = "2.2.0"
        const val MOCKITO = "4.2.0"
    }

    const val J_UNIT = "junit:junit:${Version.J_UNIT}"
    const val TEST_NG = "org.testng:testng:${Version.TEST_NG}"
    const val ANDROID_JUNIT = "androidx.test.ext:junit:${Version.ANDROID_JUNIT}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Version.ESPRESSO_CORE}"
    const val COMPOSE_BOM = Dependency.COMPOSE_BOM
    const val COMPOSE_UI = "androidx.compose.ui:${Version.COMPOSE_UI_TEST}"
    const val MOCK_WEB_SERVER = "com.squareup.okhttp3:mockwebserver:${Version.MOCK_WEB_SERVER}"
    const val TEST_COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.TEST_COROUTINES}"
    const val ROOM = "androidx.room:room-testing:${Dependency.Version.ROOM}"
    const val TEST_RUNNER = "androidx.test:runner:${Version.TEST_RUNNER}"
    const val HILT_COMPILER = Dependency.HILT_COMPILER
    const val PAGING_COMMON = "androidx.paging:paging-common:${Dependency.Version.PAGING}"
    const val CORE_TESTING = "androidx.arch.core:core-testing:${Version.CORE_TESTING}"
    const val MOCKITO = "org.mockito:mockito-core:${Version.MOCKITO}"
}
