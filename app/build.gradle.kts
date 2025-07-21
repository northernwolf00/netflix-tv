plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.googadev.tvapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.googadev.tvapp"
        minSdk = 21
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.tv.foundation)
    implementation(libs.androidx.tv.material)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Navigation
    implementation(libs.navigation)
    implementation(libs.material.navigation)
    implementation(libs.backHandler)
    implementation(libs.compose.ui)

    // Networking
    implementation(libs.coil.compose)
    implementation(libs.jetbrains.serialization)
    implementation(libs.components.resources)

    // Data
//    implementation(libs.androidx.room.compiler)
//    implementation(libs.androidx.room.runtime)
//    implementation(libs.sqlite.bundled)
//    implementation(libs.datastore.preferences)

    // Architecture
    implementation(libs.lifecycle.viewmodel)
//    implementation(libs.hilt.navigation)
    implementation(libs.hilt.android)

    // Compose & UI
    implementation(libs.compose.material3)
    implementation(libs.io.coil.kt.coil3)


}

//
//dependencies {
//    ksp(libs.androidx.room.compiler)
//    add("kspAndroid", libs.androidx.room.compiler)
//    add("kspIosSimulatorArm64", libs.androidx.room.compiler)
////    add("kspIosX64", libs.androidx.room.compiler)
//    add("kspIosArm64", libs.androidx.room.compiler)
//
//    debugImplementation(compose.uiTooling)
//}