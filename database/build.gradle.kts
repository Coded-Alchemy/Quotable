plugins {
    id(Plugin.androidLibrary)
    id(Plugin.kotlinAndroid)
    id(Plugin.ksp)
    id(Plugin.KT_LINT)
//    kotlin(Plugin.KAPT) version "1.9.10"
}

android {
    namespace = "${Config.nameSpace}.database"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk

        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles(Config.proGuardRules)
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
    annotationProcessor(Dependency.roomCompiler)
    implementation(Dependency.roomRuntime)
    implementation(Dependency.roomKtx)
    implementation(Dependency.roomPaging)
    implementation(Dependency.serialization)
    ksp(Dependency.roomCompiler)
    // Test Dependencies
    testImplementation(TestDependency.J_UNIT)
    testImplementation(TestDependency.TEST_NG)
    testImplementation(TestDependency.room)
    testImplementation(TestDependency.coroutines)
    androidTestImplementation(TestDependency.androidJUnit)
    androidTestImplementation(TestDependency.testRunner)
}
