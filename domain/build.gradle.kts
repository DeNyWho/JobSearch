plugins {
    alias(libs.plugins.jobsearch.android.library.compose)
    alias(libs.plugins.jobsearch.android.library)
    alias(libs.plugins.jobsearch.android.library.jacoco)
    alias(libs.plugins.jobsearch.android.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.jobsearch.domain"
}

dependencies {
    api(libs.androidx.compose.runtime)
    implementation(libs.paging.runtime)
    implementation(libs.kotlinx.serialization.json)
}