plugins {
    alias(libs.plugins.jobsearch.android.application)
    alias(libs.plugins.jobsearch.android.application.compose)
    alias(libs.plugins.jobsearch.android.application.jacoco)
    alias(libs.plugins.jobsearch.android.application.firebase)
    alias(libs.plugins.jobsearch.android.hilt)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.android.application)
    alias(libs.plugins.baselineprofile)
}

android {
    namespace = "com.example.jobsearch"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.jobsearch"
        versionCode = 100
        versionName = "1.0.0-alpha"

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
        create("benchmark") {
            initWith(buildTypes.getByName("release"))
            signingConfig = signingConfigs.getByName("debug")
            matchingFallbacks += listOf("release")
            isDebuggable = false
        }
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(projects.feature.auth)
    implementation(projects.feature.search)
    implementation(projects.feature.favourite)
    implementation(projects.feature.detail)
    implementation(projects.feature.messages)
    implementation(projects.feature.responses)
    implementation(projects.feature.profile)

    implementation(projects.domain)

    implementation(projects.core.uikit)
    implementation(projects.core.common)


    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3.adaptive)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.tracing.ktx)
    implementation(libs.kotlinx.coroutines.guava)
    implementation(libs.androidx.profileinstaller)
    "baselineProfile"(project(":benchmarks"))

    ksp(libs.hilt.compiler)

    debugImplementation(libs.androidx.compose.ui.testManifest)

    kspTest(libs.hilt.compiler)

    testImplementation(libs.hilt.android.testing)

    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.navigation.testing)
    androidTestImplementation(libs.hilt.android.testing)
}