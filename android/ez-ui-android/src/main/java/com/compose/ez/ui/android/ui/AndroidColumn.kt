package com.compose.ez.ui.android.ui

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import app.cash.redwood.Modifier
import app.cash.redwood.widget.ChangeListener
import app.cash.redwood.widget.Widget
import com.compose.ez.ui.api.Length
import com.compose.ez.ui.api.Padding
import com.compose.ez.ui.modifier.Weight
import com.compose.ez.ui.widget.Column

/**
 * author: wulinpeng
 * date: 2024/3/26
 * desc:
 */
class AndroidColumn(private val context: Context): Column<View>, ChangeListener {

  private val innerView = LinearLayout(context).apply {
    orientation = LinearLayout.VERTICAL
  }
  override val children: Widget.Children<View> = AndroidChildren(innerView)

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
  override val value = innerView
  override fun onEndChanges() {
    (children as AndroidChildren).widgetList.forEach {
      var weight: Weight? = null
      it.modifier.forEach { modifier ->
        if (modifier is Weight) {
          weight = modifier
        }
      }
      if (weight != null) {
        LinearLayout.LayoutParams(it.value.layoutParams).apply {
          this.weight = weight!!.weight
          it.value.layoutParams = this
        }
      }
    }
  }
}
