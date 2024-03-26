package com.compose.ez.ui.android.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import app.cash.redwood.Modifier
import app.cash.redwood.widget.Widget
import com.compose.ez.ui.api.Length
import com.compose.ez.ui.api.Padding
import com.compose.ez.ui.widget.List

/**
 * author: wulinpeng
 * date: 2024/3/26
 * desc:
 */
class AndroidList(private val context: Context): List<View> {

  private val container = LinearLayout(context).apply {
    layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    orientation = LinearLayout.VERTICAL
  }

  private val innerView = ScrollView(context).apply {
    addView(container)
  }

  override val children: Widget.Children<View> = AndroidChildren(container)

  override fun width(width: Length) {
    innerView.setWidthLength(width)
  }

  override fun height(height: Length) {
    innerView.setHeightLength(height)
  }

  override fun padding(padding: Padding) {
    innerView.setPaddingLength(padding)
  }

  override var modifier: Modifier
    get() = Modifier
    set(value) {}
  override val value: View = innerView
}
