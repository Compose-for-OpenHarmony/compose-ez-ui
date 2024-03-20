package harmony

import app.cash.redwood.Modifier
import com.compose.ez.ui.api.Length
import com.compose.ez.ui.api.Padding
import com.compose.ez.ui.widget.Button
import harmony.dom.BaseNode
import harmony.dom.ButtonNode

/**
 * author: wulinpeng
 * date: 2024/1/28
 * desc:
 */
public class HarmonyButton: Button<BaseNode> {

  private val innerNode = ButtonNode()
  override fun text(text: String?) {
    innerNode.text = text ?: ""
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

  override fun onClick(onClick: (() -> Unit)?) {
    innerNode.onClick {
      onClick?.invoke()
    }
  }

  override val value: BaseNode
    get() = innerNode

  override var modifier: Modifier = Modifier
}
