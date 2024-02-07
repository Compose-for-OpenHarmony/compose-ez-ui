package com.redwood.ui.schema

import app.cash.redwood.schema.Default
import app.cash.redwood.schema.Property
import app.cash.redwood.schema.Widget
import app.cash.redwood.ui.Dp
import app.cash.redwood.ui.dp
import com.redwood.ui.schema.api.Color
import com.redwood.ui.schema.api.FontStyle
import com.redwood.ui.schema.api.Length
import com.redwood.ui.schema.api.Padding
import com.redwood.ui.schema.api.TextSpan

/**
 * author: wulinpeng
 * date: 2024/1/28
 * desc:
 */
@Widget(2)
data class Text(
  @Property(1)
  val text: String?,

  @Property(2)
  @Default("Length.Wrap")
  val width: Length,

  @Property(3)
  @Default("Length.Wrap")
  val height: Length,

  @Property(4)
  @Default("Padding.Zero")
  val padding: Padding,

  @Property(5)
  @Default("null")
  val fontStyle: FontStyle? = null,

  @Property(6)
  @Default("Dp(15.0)")
  val fontSize: Dp = 15.dp,

  @Property(7)
  @Default("Color.Black")
  val fontColor: Color = Color.Black,

  @Property(8)
  @Default("null")
  val maxLines: Int? = null,

  @Property(9)
  @Default("null")
  val spans: List<TextSpan>? = null,
)
