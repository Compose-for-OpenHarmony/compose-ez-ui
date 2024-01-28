package harmony

import com.redwood.ui.schema.widget.Button
import com.redwood.ui.schema.widget.Column
import com.redwood.ui.schema.widget.Row
import com.redwood.ui.schema.widget.SchemaWidgetFactory
import com.redwood.ui.schema.widget.Text
import harmony.dom.BaseNode

/**
 * author: wulinpeng
 * date: 2024/1/28
 * desc:
 */
public class HarmonyWidgetFactory: SchemaWidgetFactory<BaseNode> {
  override fun Column(): Column<BaseNode> {
    return HarmonyColumn()
  }

  override fun Row(): Row<BaseNode> {
    return HarmonyRow()
  }

  override fun Text(): Text<BaseNode> {
    return HarmonyText()
  }

  override fun Button(): Button<BaseNode> {
    return HarmonyButton()
  }
}
