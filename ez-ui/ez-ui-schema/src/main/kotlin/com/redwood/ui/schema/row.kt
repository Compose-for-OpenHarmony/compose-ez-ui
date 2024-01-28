package com.redwood.ui.schema

import app.cash.redwood.schema.Children
import app.cash.redwood.schema.Default
import app.cash.redwood.schema.Property
import app.cash.redwood.schema.Widget
import com.redwood.ui.schema.api.Length
import com.redwood.ui.schema.api.Padding

/**
 * author: wulinpeng
 * date: 2024/1/28
 * desc:
 */
@Widget(4)
public data class Row(
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
  @Children(1) val children: RowScope.() -> Unit,
)

public object RowScope
