plugins {
    id(Plugin.androidLibrary)
    id(Plugin.kotlinAndroid)
    id(Plugin.KT_LINT)
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
    implementation(Dependency.retrofit)
    implementation(Dependency.gsonConverter)
    implementation(Dependency.logInterceptor)

    implementation("androidx.paging:paging-runtime:3.2.1")

    // Test dependencies
    testImplementation(TestDependency.jUnit)
    testImplementation(TestDependency.mockWebServer) // MockWebServer for mocking server responses
    testImplementation(TestDependency.coroutines) // For testing coroutines
    testImplementation("androidx.paging:paging-common:3.2.1")
    androidTestImplementation(TestDependency.androidJUnit)
}
