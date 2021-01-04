import Library.Kotlin
import Library.Room

plugins {
    id("com.android.application" /* id */)
    kotlin(module = "android")
    kotlin(module = "kapt")
}

android {
    compileSdkVersion(SdkVersion.COMPILE)

    defaultConfig {
        minSdkVersion(SdkVersion.MIN)
        targetSdkVersion(SdkVersion.TARGET)
    }
}

dependencies {
    implementation(Kotlin.Stdlib, Room.Runtime, Room.Ktx)
    kapt(Room.Compiler)
}
