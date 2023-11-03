// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugin.ANDROID_APP) version Plugin.Version.androidApp apply false
    id(Plugin.androidLibrary) version Plugin.Version.androidLibrary apply false
    id(Plugin.kotlinAndroid) version Plugin.Version.kotlinAndroid apply false
    id(Plugin.ksp) version Plugin.Version.ksp apply false
    id(Plugin.KT_LINT) version Plugin.Version.KT_LINT apply false
    id(Plugin.HILT) version Plugin.Version.HILT apply false // TODO Remove Hilt
    kotlin("kapt") version "1.9.10" // TODO Remove with Hilt
}
