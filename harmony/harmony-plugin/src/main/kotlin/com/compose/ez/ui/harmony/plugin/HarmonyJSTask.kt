package com.compose.ez.ui.harmony.plugin

import java.io.File
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

abstract class HarmonyJSTask: DefaultTask() {
  @TaskAction
  fun doTransform() {
    val task = project.tasks.getByName("compileDevelopmentExecutableKotlinJs")
    val destDir = task.outputs.files.map { it.absoluteFile }.first {
      it.absolutePath.endsWith("compileSync/js/main/developmentExecutable/kotlin")
    }
    destDir.listFiles()?.forEach {
      if(it.name.endsWith(".mjs")) {
        val lines = it.readLines()
        val newLines = mutableListOf<String>()
        var importDone = false
        for (line in lines) {
          if (line.startsWith("//# sourceMappingURL=")) {
            newLines += line.replace(".mjs.map", ".js.map")
          } else if (importDone) {
            newLines += line
          } else if (line.startsWith("//region block")) {
            importDone = true
            newLines += line
          } else {
            newLines += line.replace(Regex("""'(\./.+)\.mjs'""")) { "'${it.groupValues[1]}.js'" }
          }
        }
        it.writeText(newLines.joinToString("\n"))

        it.renameTo(File(destDir, it.name.replace(".mjs", ".js")))
      } else if(it.name.endsWith(".mjs.map")) {
        it.renameTo(File(destDir, it.name.replace(".mjs.map", ".js.map")))
      }
    }
    File(destDir, "compose-multiplatform-core-runtime.js").apply {
      writeText(readText().replace("function MovableContent(content) {\n  illegalDecoyCallException('<init>');\n}", ""))
    }
    destDir.copyRecursively(File(project.layout.buildDirectory.asFile.get(), "harmony-js"), true)
  }
}
