package harmony

import com.compose.ez.ui.widget.Button
import com.compose.ez.ui.widget.Column
import com.compose.ez.ui.widget.Image
import com.compose.ez.ui.widget.Row
import com.compose.ez.ui.widget.SchemaWidgetFactory
import com.compose.ez.ui.widget.Text
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

  override fun Image(): Image<BaseNode> {
    return HarmonyImage()
  }
}
