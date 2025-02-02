plugins {
    alias(libs.plugins.jobsearch.android.feature)
    alias(libs.plugins.jobsearch.android.library.compose)
}

android {
    namespace = "com.example.jobsearch.feature.detail"
}

dependencies {
    testImplementation(libs.hilt.android.testing)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
}
