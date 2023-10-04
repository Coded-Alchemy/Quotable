plugins {
    id(Plugin.androidLibrary)
    id(Plugin.kotlinAndroid)
}

android {
    namespace = "${Config.nameSpace}.data"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = 24

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
}

dependencies {
    // Module dependency
    implementation(project(mapOf("path" to ":database")))
    testImplementation(TestDependency.jUnit)
    androidTestImplementation(TestDependency.androidJUnit)
}