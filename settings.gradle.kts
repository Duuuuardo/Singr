pluginManagement {
  repositories {
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    gradlePluginPortal()
  }
}

plugins { id("org.gradle.toolchains.foojay-resolver-convention") version "0.4.0" }

rootProject.name = "singr-parent"

include(":discord")
