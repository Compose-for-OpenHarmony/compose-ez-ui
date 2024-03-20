package com.compose.ez.ui.api

import app.cash.redwood.ui.Dp

/**
 * author: wulinpeng
 * date: 2024/1/28
 * desc:
 */
public class Padding(
  public val start: Dp? = null,
  public val end: Dp? = null,
  public val top: Dp? = null,
  public val bottom: Dp? = null,
) {
  public companion object {
    public val Zero: Padding = Padding()
  }
}
