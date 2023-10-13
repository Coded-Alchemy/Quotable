/**
 * Object to store build plugins.
 * */
object Plugin {
    object Version {
        const val androidApp = "8.1.1"
        const val androidLibrary = androidApp
        const val kotlinAndroid = "1.8.10"
        const val ksp = "1.9.10-1.0.13"
        const val HILT = "2.44.2"
        const val KT_LINT = "11.6.0"
        const val KAPT = "1.9.10"
    }

    const val ANDROID_APP = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val javaLibrary = "java-library"
    const val kotlinJvm = "org.jetbrains.kotlin.jvm"
    const val protoBuf = "com.google.protobuf"
    const val ksp = "com.google.devtools.ksp"
    const val HILT = "com.google.dagger.hilt.android"
    const val KT_LINT = "org.jlleitschuh.gradle.ktlint"
    const val KAPT = "kapt"
}
