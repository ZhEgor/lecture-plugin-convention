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
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Lecture Plugin Convention"
// enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS") // включает такой синтаксис implementation(projects.feature.dashboard)
include(":app")
include(":domain")
include(":data")
include(":feature:auth")
include(":feature:dashboard")
include(":common")
