package com.compose.ez.ui.android.ui

import android.content.Context
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView
import app.cash.redwood.Modifier
import app.cash.redwood.ui.Dp
import app.cash.redwood.ui.toPlatformDp
import com.compose.ez.ui.api.Color
import com.compose.ez.ui.api.FontStyle
import com.compose.ez.ui.api.Length
import com.compose.ez.ui.api.Padding
import com.compose.ez.ui.api.TextSpan
import com.compose.ez.ui.widget.Button
import com.compose.ez.ui.widget.Text

/**
 * author: wulinpeng
 * date: 2024/3/26
 * desc:
 */
class AndroidButton(private val context: Context): Button<View> {

  private val innerView = android.widget.Button(context)
  override fun text(text: String?) {
    innerView.text = text
  }

  override fun width(width: Length) {
    innerView.setWidthLength(width)
  }

  override fun height(height: Length) {
    innerView.setHeightLength(height)
  }

  override fun padding(padding: Padding) {
    innerView.setPaddingLength(padding)
  }

  override fun onClick(onClick: (() -> Unit)?) {
    innerView.setOnClickListener {
      onClick?.invoke()
    }
  }

  override var modifier: Modifier = Modifier
  override val value: View= innerView
}
