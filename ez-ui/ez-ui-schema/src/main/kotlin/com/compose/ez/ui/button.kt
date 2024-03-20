package com.compose.ez.ui

import app.cash.redwood.schema.Default
import app.cash.redwood.schema.Property
import app.cash.redwood.schema.Widget
import com.compose.ez.ui.api.Length
import com.compose.ez.ui.api.Padding

/**
 * author: wulinpeng
 * date: 2024/1/28
 * desc:
 */
@Widget(3)
data class Button(
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
  val onClick: (() -> Unit)? = null,
)
