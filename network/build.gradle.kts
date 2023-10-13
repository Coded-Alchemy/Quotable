plugins {
    id(Plugin.androidLibrary)
    id(Plugin.kotlinAndroid)
    id(Plugin.KT_LINT)
    id(Plugin.ksp)
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
}

dependencies {
    // Module dependency
    implementation(project(mapOf("path" to ":database")))
    // Retrofit
    implementation(Dependency.RETROFIT)
    implementation(Dependency.GSON_CONVERTER)
    implementation(Dependency.LOG_INTERCEPTOR)
    implementation(Dependency.ROOM_RUNTIME)
    implementation(Dependency.ROOM_KTX)
    ksp(Dependency.ROOM_COMPILER)
    implementation(Dependency.PAGING_RUNTIME)

    // Test dependencies
    testImplementation(TestDependency.J_UNIT)
    testImplementation(TestDependency.MOCK_WEB_SERVER) // MockWebServer for mocking server responses
    testImplementation(TestDependency.TEST_COROUTINES) // For testing coroutines
    testImplementation(TestDependency.PAGING_COMMON)
    testImplementation(TestDependency.CORE_TESTING)
    testImplementation(TestDependency.TEST_NG)
    androidTestImplementation(TestDependency.ANDROID_JUNIT)
}
