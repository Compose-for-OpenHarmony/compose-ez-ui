import harmony.builder.ezUINode
import harmony.dom.BaseNode
import weibo.WeiboList

/**
 * author: wulinpeng
 * date: 2024/1/27
 * desc:
 */
@JsExport
@OptIn(ExperimentalJsExport::class)
class WeiboDemo {
  fun createWeiboNode(): BaseNode {
    return ezUINode {
      WeiboList()
    }
  }
}
