package com.compose.ez.ui.android.ui

import android.app.ActionBar.LayoutParams
import android.content.Context
import android.view.View
import android.view.ViewGroup
import app.cash.redwood.ui.Dp
import com.compose.ez.ui.api.Length
import com.compose.ez.ui.api.Padding

/**
 * author: wulinpeng
 * date: 2024/1/27
 * desc:
 */
public fun View.setWidthLength(width: Length) {
  when (width) {
      Length.Fill -> {
        (layoutParams ?: ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)).apply {
          this.width = LayoutParams.MATCH_PARENT
          layoutParams = this
        }
      }
      Length.Wrap -> {
        (layoutParams ?: ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)).apply {
          this.width = LayoutParams.WRAP_CONTENT
          layoutParams = this
        }
      }
      else -> {
        (layoutParams ?: ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)).apply {
          this.width = width.dp.toPx(context).toInt()
          layoutParams = this
        }
      }
  }
}

public fun View.setHeightLength(height: Length) {
  when (height) {
    Length.Fill -> {
      (layoutParams ?: ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)).apply {
        this.height = LayoutParams.MATCH_PARENT
        layoutParams = this
      }
    }
    Length.Wrap -> {
      (layoutParams ?: ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)).apply {
        this.height = LayoutParams.WRAP_CONTENT
        layoutParams = this
      }
    }
    else -> {
      (layoutParams ?: ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)).apply {
        this.height = height.dp.toPx(context).toInt()
        layoutParams = this
      }
    }
  }
}

public fun View.setPaddingLength(padding: Padding) {
  setPadding(
    padding.start?.toPx(context)?.toInt() ?: 0, padding.top?.toPx(context)?.toInt() ?: 0,
    padding.end?.toPx(context)?.toInt() ?: 0, padding.bottom?.toPx(context)?.toInt() ?: 0
  )
}

fun Dp.toPx(context: Context): Double {
  return value * context.resources.displayMetrics.density
}
