/**
 * Object to store dependencies.
 * */
object Dependency {
    object Version {
        const val appCompat = "1.6.1"
        const val coreKtx = "1.12.0"
        const val lifecycleRuntimeKtx = "2.6.2"
        const val serialization = "1.3.0"
        const val composeActivity = "1.7.2"
        const val composeBom = "2023.03.00"
        const val composeUi = "ui"
        const val composeGraphics = "ui-graphics"
        const val composeUiPreview = "ui-tooling-preview"
        const val composeMaterial = "material3"
        const val navigation = "2.7.1"
        const val retrofit = "2.9.0"
        const val logInterceptor = "4.10.0"
        const val hilt = "2.44"
        const val room = "2.5.2"
    }

    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    // ktx
    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycleRuntimeKtx}"
    // Kotlin Json Serialization
    const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Version.serialization}"
    // Compose
    const val composeActivity = "androidx.activity:activity-compose:${Version.composeActivity}"
    const val composeBom = "androidx.compose:compose-bom:${Version.composeBom}"
    const val composeUi = "androidx.compose.ui:${Version.composeUi}"
    const val composeGraphics = "androidx.compose.ui:${Version.composeGraphics}"
    const val composeUiPreview = "androidx.compose.ui:${Version.composeUiPreview}"
    const val composeMaterial = "androidx.compose.material3:${Version.composeMaterial}"
    // Navigation
    const val navigation = "androidx.navigation:navigation-compose:${Version.navigation}"
    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
    const val logInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.logInterceptor}"
    // Hilt
    const val hilt = "com.google.dagger:hilt-android:${Version.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Version.hilt}"
    // Room
    const val roomRuntime = "androidx.room:room-runtime:${Version.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Version.room}"
    const val roomKtx = "androidx.room:room-ktx:${Version.room}"
    const val roomPaging = "androidx.room:room-paging:${Version.room}"
}