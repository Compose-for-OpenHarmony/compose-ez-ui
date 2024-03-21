plugins {
  kotlin("jvm")
  `java-gradle-plugin`
  id("com.gradle.plugin-publish") version "1.2.1"
}

group = "io.github.XDMrWu"
version = "1.0.0"

publishing {
  repositories {
    maven {
      name = "localPluginRepository"
      url = uri("../../local-plugin-repository")
    }
  }
}

gradlePlugin {
  website = "https://github.com/Compose-for-OpenHarmony/compose-ez-ui"
  vcsUrl = "https://github.com/Compose-for-OpenHarmony/compose-ez-ui.git"
  plugins {
    create("HarmonyJSPlugin") {
      id = "io.github.XDMrWu.harmony.js"
      displayName = "Plugin for package Kotlin/js for Harmony"
      description = "A plugin that helps you package Kotlin/js code for Harmony"
      tags = listOf("HarmonyOS", "OpenHarmony", "Kotlin/js", "Compose")
      implementationClass = "com.compose.ez.ui.harmony.plugin.HarmonyJSPlugin"
    }
  }
}

dependencies {
  implementation(gradleApi())
}
