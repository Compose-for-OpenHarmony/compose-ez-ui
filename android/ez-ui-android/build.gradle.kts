plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
  id("app.cash.redwood")
}

android {
    namespace = "com.compose.ez.ui.android"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        consumerProguardFiles("consumer-rules.pro")
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

dependencies {

    api(libs.androidx.appCompat)
    api(project(":ez-ui-api"))
    api(project(":ez-ui-schema:compose"))
    api(project(":ez-ui-schema:widget"))
    api(project(":ez-ui-schema:modifier"))
    implementation("com.github.bumptech.glide:glide:4.12.0")
}
