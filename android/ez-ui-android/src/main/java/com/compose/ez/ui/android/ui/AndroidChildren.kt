package com.compose.ez.ui.android.ui

import android.view.View
import android.view.ViewGroup
import app.cash.redwood.widget.Widget

/**
 * author: wulinpeng
 * date: 2024/3/26
 * desc:
 */
class AndroidChildren(val parentView: ViewGroup, val onModifierUpdate: () -> Unit = {}): Widget.Children<View> {

  public val widgetList: MutableList<Widget<View>> = mutableListOf<Widget<View>>()
  override fun insert(index: Int, widget: Widget<View>) {
    widgetList.add(index, widget)
    parentView.addView(widget.value, index, widget.value.layoutParams)
  }

  override fun move(fromIndex: Int, toIndex: Int, count: Int) {
    TODO("Not yet implemented")
  }

  override fun remove(index: Int, count: Int) {
    repeat(count) {
      widgetList.removeAt(index)
    }
    parentView.removeViews(index, count)
  }

  override fun onModifierUpdated() {
    onModifierUpdate()
  }
}
