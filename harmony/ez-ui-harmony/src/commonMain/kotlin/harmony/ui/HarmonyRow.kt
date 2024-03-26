package harmony.ui

import app.cash.redwood.Modifier
import app.cash.redwood.widget.ChangeListener
import app.cash.redwood.widget.Widget
import com.compose.ez.ui.api.Length
import com.compose.ez.ui.api.Padding
import com.compose.ez.ui.modifier.Weight
import com.compose.ez.ui.widget.Row
import harmony.dom.BaseNode
import harmony.dom.RowNode

/**
 * author: wulinpeng
 * date: 2024/1/28
 * desc:
 */
public class HarmonyRow: Row<BaseNode>, ChangeListener {

  private val innerNode = RowNode()
  override val children: Widget.Children<BaseNode> = HarmonyDomChildren(innerNode)

  override fun width(width: Length) {
    innerNode.setWidthLength(width)
  }

  override fun height(height: Length) {
    innerNode.setHeightLength(height)
  }

  override fun padding(padding: Padding) {
    innerNode.setPaddingLength(padding)
  }

  override val value: BaseNode = innerNode
  override var modifier: Modifier = Modifier
  override fun onEndChanges() {
    // Update children's modifiers
    (children as HarmonyDomChildren).widgetList.forEach {
      var weight: Weight? = null
      it.modifier.forEach { modifier ->
        if (modifier is Weight) {
          weight = modifier
        }
      }
      if (weight != null) {
        it.value.setLayoutWeight(weight!!.weight)
      }
    }
  }
}
