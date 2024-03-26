plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("kotlinx-serialization")
  id("app.cash.redwood")
}

dependencies {
  implementation(project(":ez-ui-android"))
  implementation(project(":sample-weibo:ui"))
}

android {
  namespace = "com.compose.ez.ui.android"
  compileSdk = 34

  defaultConfig {
    minSdk = 24

  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
      )
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
}
