/**
 * Object that stores debug dependencies.
 * */
object DebugDependency {
    object Version {
        const val composeUiTooling = "ui-tooling"
        const val composeTestManifest = "ui-test-manifest"
    }

    const val composeUiTooling = "androidx.compose.ui:${Version.composeUiTooling}"
    const val composeTestManifest = "androidx.compose.ui:${Version.composeTestManifest}"
}
