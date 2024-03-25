package harmony

import app.cash.redwood.ui.UiConfiguration
import app.cash.redwood.widget.RedwoodView
import app.cash.redwood.widget.Widget
import harmony.dom.BaseNode
import harmony.dom.BaseNodeGroup
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * author: wulinpeng
 * date: 2024/1/28
 * desc:
 */
public class RedwoodHarmonyView(public val rootNode: BaseNodeGroup) : RedwoodView<BaseNode> {
  override val children: Widget.Children<BaseNode> = HarmonyDomChildren(rootNode)
  override val uiConfiguration: StateFlow<UiConfiguration> = MutableStateFlow(UiConfiguration())

  override fun reset() {
    rootNode.clear()
  }
}
