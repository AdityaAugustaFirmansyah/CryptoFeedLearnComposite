pluginManagement {
    repositories {
        google()
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
rootProject.name = "CryptoFeed"
include(":app")
include(":cryptofeed:domain")
include(":cryptofeed:presentation")
include(":cryptofeed:local")
include(":cryptofeed:remote")
