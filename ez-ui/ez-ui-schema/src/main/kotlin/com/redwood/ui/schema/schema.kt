package com.redwood.ui.schema

import app.cash.redwood.schema.Schema

/**
 * author: wulinpeng
 * date: 2024/1/28
 * desc:
 */
@Schema(
  [
    // layout
    Column::class,
    Row::class,
    // ui
    Text::class,
    Button::class,
    Image::class,
    // modifiers
    Weight::class,
  ],
)
interface Schema
