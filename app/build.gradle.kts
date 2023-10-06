
plugins {
    id(Plugin.androidApp)
    id(Plugin.kotlinAndroid)
    id(Plugin.ktLint)
//    id(Plugin.ksp)
    id(Plugin.hilt)
    kotlin("kapt") version "1.9.10"

}

android {
    namespace = Config.nameSpace
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.nameSpace
        minSdk = Config.minSdk
        targetSdk = 33
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(Config.proGuardFile),
                Config.proGuardRules,
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Config.kotlinCompilerExtensionVersion
    }
    packaging {
        resources {
            excludes += Config.excludes
        }
    }
}

dependencies {
    // Module dependencies
    implementation(project(mapOf("path" to ":data")))
    implementation(project(mapOf("path" to ":database")))
    implementation(project(mapOf("path" to ":network")))
    // Default app dependencies
    implementation(Dependency.coreKtx)
    implementation(Dependency.lifecycleRuntimeKtx)
    implementation(Dependency.composeActivity)
    implementation(platform(Dependency.composeBom))
    implementation(Dependency.composeUi)
    implementation(Dependency.composeGraphics)
    implementation(Dependency.composeUiPreview)
    implementation(Dependency.composeMaterial)
    implementation(Dependency.roomKtx)
    implementation("com.google.dagger:hilt-android:2.44.2")
    kapt("com.google.dagger:hilt-android-compiler:2.44.2")
    // Test Dependencies
    testImplementation(TestDependency.jUnit)
    androidTestImplementation(TestDependency.androidJUnit)
    androidTestImplementation(TestDependency.espressoCore)
    androidTestImplementation(platform(TestDependency.composeBom))
    androidTestImplementation(TestDependency.composeUi)
    debugImplementation(DebugDependency.composeUiTooling)
    debugImplementation(DebugDependency.composeTestManifest)
}

kapt {
    correctErrorTypes = true
}
