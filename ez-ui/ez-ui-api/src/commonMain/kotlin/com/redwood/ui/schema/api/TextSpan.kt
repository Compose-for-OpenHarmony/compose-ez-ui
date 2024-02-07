package com.redwood.ui.schema.api

import app.cash.redwood.ui.Dp

/**
 * author: wulinpeng
 * date: 2024/1/29
 * desc:
 */
data class TextSpan(val startIndex: Int, val endIndex: Int, val fontColor: Color, val fontSize: Dp, val fontStyle: FontStyle)
