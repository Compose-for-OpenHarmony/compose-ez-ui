package com.compose.ez.ui.android.builder

import android.content.Context
import android.view.View
import com.compose.ez.ui.android.ui.AndroidButton
import com.compose.ez.ui.android.ui.AndroidColumn
import com.compose.ez.ui.android.ui.AndroidImage
import com.compose.ez.ui.android.ui.AndroidList
import com.compose.ez.ui.android.ui.AndroidRow
import com.compose.ez.ui.android.ui.AndroidText
import com.compose.ez.ui.widget.Button
import com.compose.ez.ui.widget.Column
import com.compose.ez.ui.widget.Image
import com.compose.ez.ui.widget.List
import com.compose.ez.ui.widget.Row
import com.compose.ez.ui.widget.SchemaWidgetFactory
import com.compose.ez.ui.widget.Text

/**
 * author: wulinpeng
 * date: 2024/3/26
 * desc:
 */
class AndroidWidgetFactory(private val context: Context): SchemaWidgetFactory<View> {
  override fun Column(): Column<View> {
    return AndroidColumn(context)
  }

  override fun Row(): Row<View> {
    return AndroidRow(context)
  }

  override fun List(): List<View> {
    return AndroidList(context)
  }

  override fun Text(): Text<View> {
    return AndroidText(context)
  }

  override fun Button(): Button<View> {
    return AndroidButton(context)
  }

  override fun Image(): Image<View> {
    return AndroidImage(context)
  }
}
