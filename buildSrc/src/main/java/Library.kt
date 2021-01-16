import org.gradle.kotlin.dsl.DependencyHandlerScope

sealed class Library(
    private val group: String,
    private val name: String,
    private val version: String
) {
    val notation: String = "$group:$name:$version"

    object Gradle : Library(
        group = "com.android.tools.build",
        name = "gradle",
        version = "4.1.1"
    )

    sealed class Kotlin(private val name: String) : Library(
        group = "org.jetbrains.kotlin",
        name = name,
        version = "1.4.21"
    ) {
        object GradlePlugin : Kotlin(name = "kotlin-gradle-plugin")

        object Stdlib : Kotlin(name = "kotlin-stdlib")

        object Test : Kotlin(name = "kotlin-test")
    }

    object Material : Library(
        group = "com.google.android.material",
        name = "material",
        version = "1.2.1"
    )

    sealed class Room(private val name: String) : Library(
        group = "androidx.room",
        name = name,
        version = "2.2.5"
    ) {
        object Compiler : Room(name = "room-compiler")

        object Runtime : Room(name = "room-runtime")

        object Ktx : Room(name = "room-ktx")
    }

    object JUnit : Library(
        group = "junit",
        name = "junit",
        version = "4.13"
    )

    sealed class Mockito(
        private val group: String,
        private val name: String,
        private val version: String
    ) : Library(group, name, version) {
        object Inline : Mockito(
            group = "org.mockito",
            name = "mockito-inline",
            version = "3.7.7"
        )

        object Kotlin : Mockito(
            group = "com.nhaarman.mockitokotlin2",
            name = "mockito-kotlin",
            version = "2.2.0"
        )
    }
}

fun DependencyHandlerScope.implementation(vararg libs: Library) = libs.forEach {
    "implementation"(it.notation)
}

fun DependencyHandlerScope.testImplementation(vararg libs: Library) = libs.forEach {
    "testImplementation"(it.notation)
}

fun DependencyHandlerScope.kapt(vararg libs: Library) = libs.forEach {
    "kapt"(it.notation)
}
