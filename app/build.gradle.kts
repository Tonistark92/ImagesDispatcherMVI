plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlinSerialization)
    id("org.jlleitschuh.gradle.ktlint") version "11.1.0"
}

android {
    namespace = "com.iscoding.imagesdispatcher"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.iscoding.imagesdispatcher"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.2"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}
ktlint {
    // Optional: Customize Ktlint configuration
    version.set("0.48.0") // Set the Ktlint version
    android.set(true) // If using Android, enable Android-specific rules
    outputToConsole.set(true) // Output results to the console
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.HTML)
    }
    // Optional: Exclude files or directories
    filter {
        exclude("**/generated/**")
    }


}
dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation("com.arkivanov.mvikotlin:mvikotlin:3.3.0")
    implementation("com.arkivanov.mvikotlin:mvikotlin-main:3.0.0")
    implementation("com.arkivanov.mvikotlin:mvikotlin-extensions-coroutines:3.0.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")


    implementation("com.arkivanov.decompose:decompose:2.2.0-alpha03")
    implementation(libs.kotlinx.serialization.json)
    implementation("com.arkivanov.decompose:extensions-compose-jetbrains:2.1.4-compose-experimental")
    implementation("com.arkivanov.decompose:extensions-compose-jetpack:2.1.0")

    implementation("io.insert-koin:koin-android:3.5.3")
    implementation("io.insert-koin:koin-androidx-navigation:3.2.0-beta-1")
    implementation("io.insert-koin:koin-androidx-compose:3.5.3")

    implementation("com.arkivanov.mvikotlin:mvikotlin:3.0.0")
    implementation("com.arkivanov.mvikotlin:mvikotlin-extensions-coroutines:3.0.0")
    implementation("com.arkivanov.mvikotlin:mvikotlin-main:3.0.0")
    implementation("com.arkivanov.mvikotlin:mvikotlin-logging:3.0.0")
    implementation("com.arkivanov.mvikotlin:mvikotlin-timetravel:3.0.0")

    implementation("io.coil-kt:coil-compose:2.7.0")

}
