package com.compose.ez.ui

import app.cash.redwood.schema.Default
import app.cash.redwood.schema.Property
import app.cash.redwood.schema.Widget
import app.cash.redwood.ui.Dp
import app.cash.redwood.ui.dp
import com.compose.ez.ui.api.Color
import com.compose.ez.ui.api.FontStyle
import com.compose.ez.ui.api.Length
import com.compose.ez.ui.api.Padding
import com.compose.ez.ui.api.TextSpan
import kotlin.collections.List

/**
 * author: wulinpeng
 * date: 2024/3/27
 * desc:
 */
@Widget(7)
data class Divider(
  @Property(2)
  @Default("Length.Wrap")
  val width: Length,

  @Property(3)
  @Default("Length.Wrap")
  val height: Length,

  @Property(10)
  @Default("Color.White")
  val background: Color
)
