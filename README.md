# <center>Compose Ez UI</center>
`Compose Ez UI` is a multiplatform reactive ui based on [Redwood](https://github.com/cashapp/redwood), current support **OpenHarmony** and **Android**.
# Add Dependency
```kotlin
plugins {
  id("org.jetbrains.kotlin.multiplatform")
  id("app.cash.redwood")
  id("kotlinx-serialization")
}

kotlin {
  js {
    generateTypeScriptDefinitions()
    useEsModules()
    nodejs()
    binaries.executable()
  }
  jvm()

  sourceSets {
    commonMain {
      dependencies {
        implementation(libs.kotlinx.coroutines.core)
        implementation(libs.kotlinx.serialization.core)
        implementation(libs.kotlinx.serialization.json)
        api(project(":ez-ui-api"))
        api(project(":ez-ui-schema:compose"))
        api(project(":ez-ui-schema:widget"))
        api(project(":ez-ui-schema:modifier"))
      }
    }
  }
}

```
# Sample Code
## Common UI
```kotlin
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
## OpenHarmony
In `jsMain` module
```kotlin
@JsExport
@OptIn(ExperimentalJsExport::class)
class CounterDemo {
  fun createCounterNode(): BaseNode {
    return ezUINode {
      Counter(0)
    }
  }
}
```
In harmony project
```typescript
@Entry
@Component
struct Index {

  createDomNode(): BaseNode {
    return new CounterDemo().createCounterNode()
  }

  build() {
    Stack() {
      createUIFromNode(this.createDomNode())
    }
  }
}
```
## Android
```kotlin
class MainActivity: AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(ezUIView(this) {
      Counter()
    }.apply {
      setBackgroundColor(Color.WHITE)
    })
  }
}
```
