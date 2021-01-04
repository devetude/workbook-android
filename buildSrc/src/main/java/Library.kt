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
    }

    object Material : Library(
        group = "com.google.android.material",
        name = "material",
        version = "1.2.1"
    )
}

fun DependencyHandlerScope.implementation(vararg libs: Library) = libs.forEach {
    "implementation"(it.notation)
}
