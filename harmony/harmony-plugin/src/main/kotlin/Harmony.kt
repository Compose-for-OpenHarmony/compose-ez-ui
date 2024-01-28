import java.io.File

/**
 * author: wulinpeng
 * date: 2024/1/27
 * desc:
 */
fun main() {
  val destDir = File("samples/counter/build/compileSync/js/main/developmentExecutable/kotlin")
  destDir.listFiles()?.forEach {
    if(it.name.endsWith(".mjs")) {
      val lines = it.readLines()
      val newLines = ArrayList<String>(lines.size)
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
//      newLines.add(0, "// @ts-nocheck")
      it.writeText(newLines.joinToString("\n"))

      it.renameTo(File(destDir, it.name.replace(".mjs", ".js")))
    } else if(it.name.endsWith(".mjs.map")) {
      it.renameTo(File(destDir, it.name.replace(".mjs.map", ".js.map")))
    }
  }
  File(destDir, "compose-multiplatform-core-runtime.js").apply {
    writeText(readText().replace("function MovableContent(content) {\n  illegalDecoyCallException('<init>');\n}", ""))
  }
}
