import Library.Kotlin
import Library.Material

plugins {
    id("com.android.application" /* id */)
    kotlin(module = "android")
}

android {
    compileSdkVersion(SdkVersion.COMPILE)

    defaultConfig {
        minSdkVersion(SdkVersion.MIN)
        targetSdkVersion(SdkVersion.TARGET)
        versionCode = AppVersion.CODE
        versionName = AppVersion.NAME
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug" /* name */) {
            minifyEnabled(enabled = false)
            isShrinkResources = false
        }

        getByName("release" /* name */) {
            minifyEnabled(enabled = true)
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile(name = "proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(Kotlin.Stdlib, Material)
}
