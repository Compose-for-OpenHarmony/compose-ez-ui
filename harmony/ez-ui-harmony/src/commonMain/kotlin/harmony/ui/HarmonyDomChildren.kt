package harmony.ui

import app.cash.redwood.widget.Widget
import harmony.dom.BaseNode
import harmony.dom.BaseNodeGroup

/**
 * author: wulinpeng
 * date: 2024/1/28
 * desc:
 */
public class HarmonyDomChildren(public val parent: BaseNodeGroup, public val onModifierUpdate: () -> Unit = {}): Widget.Children<BaseNode> {

  public val widgetList: MutableList<Widget<BaseNode>> = mutableListOf<Widget<BaseNode>>()

  override fun insert(index: Int, widget: Widget<BaseNode>) {
    widgetList.add(index, widget)
    widget.value.parentNode = parent
    parent.insert(index, widget.value)
  }

  override fun move(fromIndex: Int, toIndex: Int, count: Int) {
    widgetList.move(fromIndex, toIndex, count)
    parent.move(fromIndex, toIndex, count)
  }

  override fun remove(index: Int, count: Int) {
    widgetList.remove(index, count)
    parent.remove(index, count)
  }

  override fun onModifierUpdated() {
    onModifierUpdate()
  }

}

internal fun <T> MutableList<T>.move(fromIndex: Int, toIndex: Int, count: Int) {
  val dest = if (fromIndex > toIndex) toIndex else toIndex - count
  if (count == 1) {
    if (fromIndex == toIndex + 1 || fromIndex == toIndex - 1) {
      // Adjacent elements, perform swap to avoid backing array manipulations.
      val fromEl = get(fromIndex)
      val toEl = set(toIndex, fromEl)
      set(fromIndex, toEl)
    } else {
      val fromEl = removeAt(fromIndex)
      add(dest, fromEl)
    }
  } else {
    val subView = subList(fromIndex, fromIndex + count)
    val subCopy = subView.toMutableList()
    subView.clear()
    addAll(dest, subCopy)
  }
}

internal fun <T> MutableList<T>.remove(index: Int, count: Int) {
  if (count == 1) {
    removeAt(index)
  } else {
    subList(index, index + count).clear()
  }
}
