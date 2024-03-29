package harmony.ui

import app.cash.redwood.Modifier
import app.cash.redwood.ui.Dp
import app.cash.redwood.ui.toPlatformDp
import com.compose.ez.ui.api.Color
import com.compose.ez.ui.api.FontStyle
import com.compose.ez.ui.api.Length
import com.compose.ez.ui.api.Padding
import com.compose.ez.ui.api.TextSpan
import com.compose.ez.ui.widget.Text
import harmony.dom.BaseNode
import harmony.dom.OhTextSpan
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

  override fun spans(spans: List<TextSpan>?) {
    innerNode.setSpans(spans?.map {
      OhTextSpan().apply {
        startIndex = it.startIndex
        endIndex = it.endIndex
        fontColor = it.fontColor.value
        fontSize = it.fontSize.toPlatformDp()
        fontStyle = when(it.fontStyle) {
          FontStyle.Normal -> harmony.dom.OhFontStyle.Normal
          FontStyle.Italic -> harmony.dom.OhFontStyle.Italic
        }
      }
    }?.toTypedArray() ?: emptyArray())
  }

  override fun textCenter(textCenter: Boolean) {
    innerNode.setTextCenter(textCenter)
  }

  override val value: BaseNode
    get() = innerNode
  override var modifier: Modifier = Modifier
}
