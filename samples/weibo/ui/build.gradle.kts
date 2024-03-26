import org.gradle.kotlin.dsl.support.kotlinCompilerOptions

plugins {
  id("org.jetbrains.kotlin.multiplatform")
  id("app.cash.redwood")
  id("kotlinx-serialization")
}

kotlin {
  js {
    generateTypeScriptDefinitions()
    useEsModules()
    nodejs()
    binaries.executable()
  }
  jvm()

  sourceSets {
    commonMain {
      dependencies {
        implementation(libs.kotlinx.coroutines.core)
        implementation(libs.kotlinx.serialization.core)
        implementation(libs.kotlinx.serialization.json)
        api(project(":ez-ui-api"))
        api(project(":ez-ui-schema:compose"))
        api(project(":ez-ui-schema:widget"))
        api(project(":ez-ui-schema:modifier"))
      }
    }
  }
}
