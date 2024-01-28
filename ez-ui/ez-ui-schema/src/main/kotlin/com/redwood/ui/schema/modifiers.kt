package com.redwood.ui.schema

import app.cash.redwood.schema.Modifier

/**
 * author: wulinpeng
 * date: 2024/1/28
 * desc:
 */
@Modifier(1, ColumnScope::class, RowScope::class)
public data class Weight(
  val weight: Float,
)
