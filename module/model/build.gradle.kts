import Library.Kotlin

plugins {
    id("com.android.application" /* id */)
    kotlin(module = "android")
}

android {
    compileSdkVersion(SdkVersion.COMPILE)
}

dependencies {
    implementation(Kotlin.Stdlib)
}
