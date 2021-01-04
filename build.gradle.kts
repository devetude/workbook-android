buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(Library.Gradle.notation)
        classpath(Library.Kotlin.GradlePlugin.notation)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register(name = "clean", type = Delete::class) {
    delete(rootProject.buildDir)
}
