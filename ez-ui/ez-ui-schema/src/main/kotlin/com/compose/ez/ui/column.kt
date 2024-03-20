package com.compose.ez.ui

import app.cash.redwood.schema.Children
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
@Widget(1)
public data class Column(
    @Property(1)
  @Default("Length.Wrap")
  val width: Length,

    @Property(2)
  @Default("Length.Wrap")
  val height: Length,

    @Property(3)
  @Default("Padding.Zero")
  val padding: Padding,

    /**
   * A slot to add widgets in.
   */
  @Children(1) val children: ColumnScope.() -> Unit,
)

public object ColumnScope
