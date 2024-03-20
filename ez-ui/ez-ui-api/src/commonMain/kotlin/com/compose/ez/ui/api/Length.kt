package com.compose.ez.ui.api

import app.cash.redwood.ui.Dp
import app.cash.redwood.ui.dp

/**
 * author: wulinpeng
 * date: 2024/1/28
 * desc:
 */
public class Length(public val dp: Dp) {
  public companion object {
    /**
     * wrap self content size
     */
    public val Wrap: Length = Length(0.dp)

    /**
     * fill parent size
     */
    public val Fill: Length = Length(0.dp)
  }
}
