# <center>Compose Ez UI</center>
`Compose Ez UI` is a multiplatform reactive ui based on [Redwood](https://github.com/cashapp/redwood), current support **OpenHarmony** and **Android**.
# Add Dependency
```kotlin
apply plugin: 'org.jetbrains.kotlin.multiplatform'
apply plugin: 'app.cash.redwood'

kotlin {
  js {
    generateTypeScriptDefinitions()
    useEsModules()
    nodejs()
    binaries.executable()
  }

  sourceSets {
    commonMain {
      dependencies {
        implementation libs.kotlinx.coroutines.core
      }
    }
    jsMain {
      dependencies {
        implementation project(":ez-ui-harmony")
      }
    }
  }
}
```
# Sample Code
```kotlin
@JsExport
@OptIn(ExperimentalJsExport::class)
class CounterDemo {
  fun createCounterNode(): BaseNode {
    return CreateHarmonyNode().createNode {
      Counter(0)
    }
  }
}

@Composable
fun Counter(value: Int = 0) {
  var count by remember { mutableStateOf(0) }

  Column(
    Length.Fill, Length.Fill,
    padding = Padding(10.dp, 10.dp, 10.dp)
  ) {
    Row(Length.Fill, Length.Wrap, padding = Padding(10.dp, 10.dp, 10.dp)) {
      Button("Add", onClick = { count++ })
      Text("Count is $count")
    }
  }
}
```
