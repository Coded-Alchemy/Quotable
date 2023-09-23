plugins {
    id(Plugin.androidLibrary)
    id(Plugin.kotlinAndroid)
}

android {
    namespace = "${Config.nameSpace}.network"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
}

dependencies {
    // Module dependency
    implementation(project(mapOf("path" to ":data")))
    // Retrofit
    implementation(Dependency.retrofit)
    implementation(Dependency.gsonConverter)
    implementation(Dependency.logInterceptor)
    // Test dependencies
    testImplementation(TestDependency.jUnit)
    testImplementation(TestDependency.mockWebServer) // MockWebServer for mocking server responses
    testImplementation(TestDependency.coroutines) // For testing coroutines
    androidTestImplementation(TestDependency.androidJUnit)
}