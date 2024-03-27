package com.compose.ez.ui.android.ui

import android.content.Context
import android.view.View
import android.widget.FrameLayout
import app.cash.redwood.Modifier
import com.compose.ez.ui.api.Color
import com.compose.ez.ui.api.Length
import com.compose.ez.ui.widget.Divider

/**
 * author: wulinpeng
 * date: 2024/3/27
 * desc:
 */
class AndroidDivider(private val context: Context): Divider<View> {

  private val innerView = FrameLayout(context)

  override fun width(width: Length) {
    innerView.setWidthLength(width)
  }

  override fun height(height: Length) {
    innerView.setHeightLength(height)
  }

  override fun background(background: Color) {
    innerView.setBackgroundColor(android.graphics.Color.parseColor(background.value))
  }

  override var modifier: Modifier = Modifier
  override val value: View = innerView
}
