pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
    }
}
rootProject.name = "JobSearch"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")

include(":lint")
include(":benchmarks")
include(":core:uikit")
include(":core:common")
include(":core:testing")
include(":domain")
include(":data:local")
include(":data:network")
include(":data:source")
include(":feature:auth")
include(":feature:search")
include(":feature:favourite")
