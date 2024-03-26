package harmony.ui

import app.cash.redwood.Modifier
import com.compose.ez.ui.api.Length
import com.compose.ez.ui.api.Padding
import com.compose.ez.ui.widget.Image
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
