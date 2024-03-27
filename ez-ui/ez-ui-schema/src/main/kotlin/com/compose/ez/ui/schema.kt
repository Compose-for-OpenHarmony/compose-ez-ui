package com.compose.ez.ui

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
    List::class,
    // ui
    Text::class,
    Button::class,
    Image::class,
    Divider::class,
    // modifiers
    Weight::class,
  ],
)
interface Schema
