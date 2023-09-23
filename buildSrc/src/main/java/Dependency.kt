/**
 * Object to store dependencies.
 * */
object Dependency {
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    // ktx
    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycleRuntimeKtx}"
    // Compose
    const val composeActivity = "androidx.activity:activity-compose:${Version.composeActivity}"
    const val composeBom = "androidx.compose:compose-bom:2023.03.00"
    const val composeUi = "androidx.compose.ui:${Version.composeUi}"
    const val composeGraphics = "androidx.compose.ui:${Version.composeGraphics}"
    const val composeUiPreview = "androidx.compose.ui:${Version.composeUiPreview}"
    const val composeMaterial = "androidx.compose.material3:${Version.composeMaterial}"
    const val navigation = "androidx.navigation:navigation-compose:${Version.navigation}"
    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    // Hilt
    const val hilt = "com.google.dagger:hilt-android:${Version.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Version.hilt}"
}