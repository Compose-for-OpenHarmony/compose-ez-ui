plugins {
  id("org.jetbrains.kotlin.multiplatform")
  id("app.cash.redwood")
  id("kotlinx-serialization")
  id("io.github.XDMrWu.harmony.js")
}

kotlin {
  js {
    generateTypeScriptDefinitions()
    useEsModules()
    nodejs()
    binaries.executable()
  }

  sourceSets {
    commonMain {
      dependencies {
        implementation(libs.kotlinx.coroutines.core)
        implementation(libs.kotlinx.serialization.core)
        implementation(libs.kotlinx.serialization.json)
      }
    }
    jsMain {
      dependencies {
        implementation(project(":redwood-harmony"))
      }
    }
  }
}
