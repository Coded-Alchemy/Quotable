plugins {
    id(Plugin.androidLibrary)
    id(Plugin.kotlinAndroid)
    id(Plugin.KT_LINT)
    id(Plugin.HILT)
    kotlin(Plugin.KAPT) version Plugin.Version.KAPT
}

android {
    namespace = "${Config.nameSpace}.data"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk

        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles(Config.proGuardConsumer)
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
}

kapt {
    correctErrorTypes = true
}

dependencies {
    // Module dependency
    implementation(project(mapOf("path" to ":database")))
    implementation(Dependency.HILT)
    annotationProcessor(Dependency.HILT_COMPILER)
    // Test dependencies
    testImplementation(TestDependency.TEST_RUNNER)
    testImplementation(TestDependency.J_UNIT)
    testImplementation(TestDependency.MOCKITO)
    androidTestImplementation(TestDependency.ANDROID_JUNIT)
}
