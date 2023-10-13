/**
 * Object that stores debug dependencies.
 * */
object DebugDependency {
    object Version {
        const val COMPOSE_UI_TOOLING = "ui-tooling"
        const val COMPOSE_TEST_MANIFEST = "ui-test-manifest"
    }

    const val COMPOSE_UI_TOOLING = "androidx.compose.ui:${Version.COMPOSE_UI_TOOLING}"
    const val COMPOSE_TEST_MANIFEST = "androidx.compose.ui:${Version.COMPOSE_TEST_MANIFEST}"
}
