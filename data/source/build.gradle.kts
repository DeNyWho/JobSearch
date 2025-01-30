plugins {
    alias(libs.plugins.jobsearch.android.library)
    alias(libs.plugins.jobsearch.android.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.jobsearch.data.source"
}

dependencies {
    implementation(projects.domain)
    implementation(projects.core.common)
    implementation(projects.data.network)
    implementation(projects.data.local)

    implementation(libs.paging.runtime)
    implementation(libs.kotlinx.serialization.json)

    testImplementation(libs.junit)
}