import harmony.CreateHarmonyNode
import harmony.dom.BaseNode

/**
 * author: wulinpeng
 * date: 2024/1/27
 * desc:
 */
@JsExport
@OptIn(ExperimentalJsExport::class)
class CounterDemo {
  fun createCounterNode(): BaseNode {
    return CreateHarmonyNode().createNode {
      Counter(0)
    }
  }
}
