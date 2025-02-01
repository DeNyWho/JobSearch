plugins {
    alias(libs.plugins.jobsearch.android.library)
    alias(libs.plugins.jobsearch.android.library.jacoco)
}

android {
    namespace = "com.example.jobsearch.core.testing"
}

dependencies {
    api(kotlin("test"))
    api(libs.androidx.compose.ui.test)
    api(projects.core.common)
    api(projects.core.uikit)

    debugApi(libs.androidx.compose.ui.testManifest)

    implementation(libs.androidx.test.rules)
    implementation(libs.hilt.android.testing)
    implementation(libs.kotlinx.coroutines.test)
    implementation(libs.kotlinx.datetime)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
}