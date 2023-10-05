plugins {
    id(Plugin.androidApp)
    id(Plugin.kotlinAndroid)
    id(Plugin.ktLint)
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
                Config.proGuardRules
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
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
    testOptions {
        managedDevices {
            devices {
                maybeCreate<com.android.build.api.dsl.ManagedVirtualDevice>("pixel2api30").apply {
                    device = "Pixel 2" // Use device profiles you typically see in Android Studio.
                    apiLevel = 30 // Use only API levels 27 and higher.
                    systemImageSource = "aosp" // To include Google services, use "google".
                }
                maybeCreate<com.android.build.api.dsl.ManagedVirtualDevice>("nexus9api30").apply {
                    device = "Nexus 9"
                    apiLevel = 30
                    systemImageSource = "aosp"
                }
                groups {
                    maybeCreate("phoneAndTablet").apply {
                        targetDevices.add(devices["pixel2api30"])
                        targetDevices.add(devices["nexus9api30"])
                    }
                }
            }
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
    // Added app dependencies
    implementation(Dependency.roomKtx)
    implementation(Dependency.navigation)
    implementation(Dependency.navRunTime)
    // Test Dependencies
    testImplementation(TestDependency.J_UNIT)
    androidTestImplementation(TestDependency.androidJUnit)
    androidTestImplementation(TestDependency.espressoCore)
    androidTestImplementation(platform(TestDependency.composeBom))
    androidTestImplementation(TestDependency.composeUi)
    debugImplementation(DebugDependency.composeUiTooling)
    debugImplementation(DebugDependency.composeTestManifest)
}
