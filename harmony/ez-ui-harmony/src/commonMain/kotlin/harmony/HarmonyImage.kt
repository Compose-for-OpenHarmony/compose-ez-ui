package harmony

import app.cash.redwood.Modifier
import com.redwood.ui.schema.api.Length
import com.redwood.ui.schema.api.Padding
import com.redwood.ui.schema.widget.Image
import harmony.dom.BaseNode
import harmony.dom.ImageNode

/**
 * author: wulinpeng
 * date: 2024/1/29
 * desc:
 */
class HarmonyImage: Image<BaseNode> {

  private val innerNode = ImageNode()

  override fun url(url: String) {
    innerNode.setUrl(url)
  }

  override fun width(width: Length) {
    innerNode.setWidthLength(width)
  }

  override fun height(height: Length) {
    innerNode.setHeightLength(height)
  }

  override fun padding(padding: Padding) {
    innerNode.setPaddingLength(padding)
  }

  override fun circle(isCircle: Boolean) {
    innerNode.setIsCircle(isCircle)
  }

  override var modifier: Modifier = Modifier
  override val value: BaseNode = innerNode
}
