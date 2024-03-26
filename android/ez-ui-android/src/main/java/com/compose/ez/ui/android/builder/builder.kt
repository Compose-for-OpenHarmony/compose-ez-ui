package com.compose.ez.ui.android.builder

import android.content.Context
import android.view.View
import android.widget.FrameLayout
import androidx.compose.runtime.Composable
import app.cash.redwood.compose.AndroidUiDispatcher
import app.cash.redwood.compose.RedwoodComposition
import com.compose.ez.ui.widget.SchemaWidgetFactories
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.plus

/**
 * author: wulinpeng
 * date: 2024/3/26
 * desc:
 */
fun ezUIView(context: Context, content: @Composable () -> Unit): View {
  val rootView = FrameLayout(context)
  val composition = RedwoodComposition(
    scope = CoroutineScope(AndroidUiDispatcher.Main),
    view = AndroidRedwoodView(rootView),
    provider = SchemaWidgetFactories(
      Schema = AndroidWidgetFactory(context)
    ),
  )
  composition.setContent {
    content()
  }
  return rootView
}
