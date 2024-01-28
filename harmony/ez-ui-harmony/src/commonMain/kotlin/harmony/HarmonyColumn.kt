package harmony

import app.cash.redwood.Modifier
import app.cash.redwood.widget.ChangeListener
import app.cash.redwood.widget.Widget
import com.redwood.ui.schema.api.Length
import com.redwood.ui.schema.api.Padding
import com.redwood.ui.schema.modifier.Weight
import com.redwood.ui.schema.widget.Column
import harmony.dom.BaseNode
import harmony.dom.ColumnNode

/**
 * author: wulinpeng
 * date: 2024/1/28
 * desc:
 */
public class HarmonyColumn: Column<BaseNode>, ChangeListener {

  private val innerNode = ColumnNode()
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
