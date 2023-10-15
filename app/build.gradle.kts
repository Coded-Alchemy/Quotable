plugins {
    id(Plugin.ANDROID_APP)
    id(Plugin.kotlinAndroid)
    id(Plugin.KT_LINT)
    id(Plugin.HILT)
    kotlin(Plugin.KAPT) version Plugin.Version.KAPT
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
    implementation(Dependency.CORE_KTX)
    implementation(Dependency.LIFECYCLE_RUNTIME_KTX)
    implementation(Dependency.COMPOSE_ACTIVITY)
    implementation(platform(Dependency.COMPOSE_BOM))
    implementation(Dependency.COMPOSE_UI)
    implementation(Dependency.COMPOSE_GRAPHICS)
    implementation(Dependency.COMPOSE_UI_PREVIEW)
    implementation(Dependency.COMPOSE_MATERIAL)
    // Added app dependencies
    implementation(Dependency.ROOM_KTX)
    implementation(Dependency.NAVIGATION)
    implementation(Dependency.NAVIGATION_RUNTIME)
    implementation(Dependency.HILT)
    implementation(Dependency.HILT_COMPOSE)
    kapt(Dependency.HILT_COMPILER)
    implementation(Dependency.PAGING_COMPOSE)
    // Test Dependencies
    testImplementation(TestDependency.J_UNIT)
    androidTestImplementation(TestDependency.ANDROID_JUNIT)
    androidTestImplementation(TestDependency.ESPRESSO_CORE)
    androidTestImplementation(platform(TestDependency.COMPOSE_BOM))
    androidTestImplementation(TestDependency.COMPOSE_UI)
    debugImplementation(DebugDependency.COMPOSE_UI_TOOLING)
    debugImplementation(DebugDependency.COMPOSE_TEST_MANIFEST)
    kaptTest(TestDependency.HILT_COMPILER)
    kaptAndroidTest(TestDependency.HILT_COMPILER)
//    androidTestImplementation("androidx.navigation:navigation-testing:${Dependency.Version.NAVIGATION}")
//    androidTestImplementation("androidx.hilt:hilt-navigation-compose:1.1.0-beta01")
}

kapt {
    correctErrorTypes = true
}
