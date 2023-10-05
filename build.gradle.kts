// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugin.androidApp) version Plugin.Version.androidApp apply false
    id(Plugin.androidLibrary) version Plugin.Version.androidLibrary apply false
    id(Plugin.kotlinAndroid) version Plugin.Version.kotlinAndroid apply false
    id(Plugin.ksp) version Plugin.Version.ksp apply false
    id(Plugin.ktLint) version Plugin.Version.ktLint apply false
}
