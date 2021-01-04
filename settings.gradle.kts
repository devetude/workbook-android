includeModules()
rootProject.name = "workbook"

fun includeModules() {
    val modules = setOf(":app" to "app")

    modules.forEach { (projectPath, projectDirPath) ->
        include(projectPath)
        project(projectPath).projectDir = file(projectDirPath)
    }
}
