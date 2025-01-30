plugins {
    alias(libs.plugins.jobsearch.android.library)
    alias(libs.plugins.jobsearch.android.hilt)
    alias(libs.plugins.jobsearch.android.room)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.jobsearch.data.local"
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
    implementation(projects.domain)
    implementation(libs.paging.runtime)
    implementation(libs.room.paging)
    implementation(libs.kotlinx.datetime)

    testImplementation(libs.junit)
}