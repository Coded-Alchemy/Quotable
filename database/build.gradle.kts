plugins {
    id(Plugin.androidLibrary)
    id(Plugin.kotlinAndroid)
    id(Plugin.ksp)
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
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
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")
    ksp(Dependency.roomCompiler)
    testImplementation(TestDependency.jUnit)
    testImplementation("org.testng:testng:6.9.6")
    testImplementation(TestDependency.room)
    androidTestImplementation(TestDependency.androidJUnit)
}