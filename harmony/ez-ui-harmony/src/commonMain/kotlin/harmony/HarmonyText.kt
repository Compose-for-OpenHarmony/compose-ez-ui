package harmony

import app.cash.redwood.Modifier
import app.cash.redwood.ui.Dp
import app.cash.redwood.ui.toPlatformDp
import com.redwood.ui.schema.api.Color
import com.redwood.ui.schema.api.FontStyle
import com.redwood.ui.schema.api.Length
import com.redwood.ui.schema.api.Padding
import com.redwood.ui.schema.widget.Text
import harmony.dom.BaseNode
import harmony.dom.TextNode

/**
 * author: wulinpeng
 * date: 2024/1/28
 * desc:
 */
public class HarmonyText: Text<BaseNode> {

  private val innerNode = TextNode()
  override fun text(text: String?) {
    innerNode.setText(text ?: "")
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

  override fun fontStyle(fontStyle: FontStyle?) {
    when(fontStyle) {
      FontStyle.Normal -> innerNode.setFontStyle(harmony.dom.OhFontStyle.Normal)
      FontStyle.Italic -> innerNode.setFontStyle(harmony.dom.OhFontStyle.Italic)
      else -> {}
    }
  }

  override fun fontSize(fontSize: Dp) {
    innerNode.setFontSize(fontSize.toPlatformDp())
  }

  override fun fontColor(fontColor: Color) {
    innerNode.setFontColor(fontColor.value)
  }

  override fun maxLines(maxLines: Int?) {
    maxLines?.apply {
      innerNode.setMaxLines(this)
    }
  }

  override val value: BaseNode
    get() = innerNode
  override var modifier: Modifier = Modifier
}
