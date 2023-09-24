/**
 * Object to store build plugins.
 * */
object Plugin {
    const val androidApp = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val javaLibrary = "java-library"
    const val kotlinJvm = "org.jetbrains.kotlin.jvm"
    const val protoBuf = "com.google.protobuf"
    const val ksp = "com.google.devtools.ksp"
    const val hilt = "com.google.dagger.hilt.android"

    object Version {
        const val androidApp = "8.1.1"
        const val androidLibrary = androidApp
        const val kotlinAndroid = "1.8.10"
        const val ksp = "1.8.10-1.0.9"
    }
}