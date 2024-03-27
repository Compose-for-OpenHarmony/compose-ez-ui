package com.compose.ez.ui.android.ui

import android.content.Context
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.Gravity
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
import com.compose.ez.ui.widget.Text

/**
 * author: wulinpeng
 * date: 2024/3/26
 * desc:
 */
class AndroidText(private val context: Context): Text<View> {

  private val innerView = TextView(context)
  private var text: String? = null
  private var spans: List<TextSpan>? = null
  override fun text(text: String?) {
    this.text = text
    triggerTextRender()
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

  override fun fontStyle(fontStyle: FontStyle?) {
    when(fontStyle) {
      FontStyle.Normal -> innerView.setTypeface(innerView.typeface, Typeface.NORMAL)
      FontStyle.Italic -> innerView.setTypeface(innerView.typeface, Typeface.ITALIC)
      else -> {}
    }
  }

  override fun fontSize(fontSize: Dp) {
    innerView.textSize = fontSize.toPlatformDp().toFloat()
  }

  override fun fontColor(fontColor: Color) {
    innerView.setTextColor(android.graphics.Color.parseColor(fontColor.value))
  }

  override fun maxLines(maxLines: Int?) {
    innerView.maxLines = maxLines ?: Int.MAX_VALUE
  }

  override fun spans(spans: List<TextSpan>?) {
    this.spans = spans
    triggerTextRender()
  }

  override fun textCenter(textCenter: Boolean) {
    if (textCenter) {
      innerView.gravity = Gravity.CENTER
    } else {
      innerView.gravity = Gravity.START
    }
  }

  private fun triggerTextRender() {
    text ?: return
    if (spans.isNullOrEmpty()) {
      innerView.text = text
      return
    }
    val content = SpannableString(text)
    spans?.forEach {
      content.setSpan(ForegroundColorSpan(android.graphics.Color.parseColor(it.fontColor.value)), it.startIndex, it.endIndex, Spanned.SPAN_INCLUSIVE_INCLUSIVE)
    }
    innerView.text = content
  }

  override var modifier: Modifier = Modifier
  override val value: View= innerView
}
