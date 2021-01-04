includeModules()
rootProject.name = "workbook"

fun includeModules() {
    val rootPath = "module"
    val modules = setOf(
        ":app" to "app",
        ":model" to "$rootPath/model"
    )

    modules.forEach { (projectPath, projectDirPath) ->
        include(projectPath)
        project(projectPath).projectDir = file(projectDirPath)
    }
}
