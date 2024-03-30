import harmony.builder.ezUINode
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
    return ezUINode {
      Counter(0)
    }
  }
}
