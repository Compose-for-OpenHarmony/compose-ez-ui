package harmony.builder

import com.compose.ez.ui.widget.Button
import com.compose.ez.ui.widget.Column
import com.compose.ez.ui.widget.Image
import com.compose.ez.ui.widget.List
import com.compose.ez.ui.widget.Row
import com.compose.ez.ui.widget.SchemaWidgetFactory
import com.compose.ez.ui.widget.Text
import harmony.dom.BaseNode
import harmony.ui.HarmonyButton
import harmony.ui.HarmonyColumn
import harmony.ui.HarmonyImage
import harmony.ui.HarmonyList
import harmony.ui.HarmonyRow
import harmony.ui.HarmonyText

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

  override fun List(): List<BaseNode> {
    return HarmonyList()
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
