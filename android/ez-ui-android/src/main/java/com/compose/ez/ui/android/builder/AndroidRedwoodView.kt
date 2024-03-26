package com.compose.ez.ui.android.builder

import android.content.Context
import android.view.View
import android.view.ViewGroup
import app.cash.redwood.ui.UiConfiguration
import app.cash.redwood.widget.RedwoodView
import app.cash.redwood.widget.Widget
import com.compose.ez.ui.android.ui.AndroidChildren
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * author: wulinpeng
 * date: 2024/3/26
 * desc:
 */
class AndroidRedwoodView(val rootView: ViewGroup): RedwoodView<View> {
  override val children: Widget.Children<View> = AndroidChildren(rootView)
  override val uiConfiguration: StateFlow<UiConfiguration> = MutableStateFlow(UiConfiguration())

  override fun reset() {
    rootView.removeAllViews()
  }
}
