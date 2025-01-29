import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.example.jobsearch.buildlogic.convention.configureKotlinAndroid
import com.example.jobsearch.buildlogic.convention.configurePrintApksTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("jobsearch.android.lint")
                apply("com.dropbox.dependency-guard")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 35
                defaultConfig.minSdk = 26
                @Suppress("UnstableApiUsage")
                testOptions.animationsDisabled = true
            }
            extensions.configure<ApplicationAndroidComponentsExtension> {
                configurePrintApksTask(this)
            }
        }
    }

}
