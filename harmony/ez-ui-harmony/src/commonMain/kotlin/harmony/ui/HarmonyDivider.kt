package harmony.ui

import app.cash.redwood.Modifier
import com.compose.ez.ui.api.Color
import com.compose.ez.ui.api.Length
import com.compose.ez.ui.widget.Divider
import harmony.dom.BaseNode
import harmony.dom.DividerNode

/**
 * author: wulinpeng
 * date: 2024/3/27
 * desc:
 */
class HarmonyDivider: Divider<BaseNode> {

  private val innerNode = DividerNode()

  override fun width(width: Length) {
    innerNode.setWidthLength(width)
  }

  override fun height(height: Length) {
    innerNode.setHeightLength(height)
  }

  override fun background(background: Color) {
    innerNode.setBackgroundColor(background.value)
  }

  override var modifier: Modifier = Modifier
  override val value: BaseNode = innerNode
}
