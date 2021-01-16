import Library.JUnit
import Library.Kotlin
import Library.Mockito
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
    testImplementation(Kotlin.Test, JUnit, Mockito.Inline, Mockito.Kotlin)
    kapt(Room.Compiler)
}
