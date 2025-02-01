plugins {
    alias(libs.plugins.jobsearch.android.library)
    alias(libs.plugins.jobsearch.android.library.jacoco)
    alias(libs.plugins.jobsearch.android.hilt)
    alias(libs.plugins.kotlin.serialization)
}
android {
    namespace = "com.example.jobsearch.core.common"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}

dependencies {

    implementation(libs.kotlinx.serialization.json)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
}