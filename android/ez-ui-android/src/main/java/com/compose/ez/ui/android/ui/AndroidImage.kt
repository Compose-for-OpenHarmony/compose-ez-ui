package com.compose.ez.ui.android.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.Typeface
import android.net.Uri
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import app.cash.redwood.Modifier
import app.cash.redwood.ui.Dp
import app.cash.redwood.ui.toPlatformDp
import com.bumptech.glide.Glide
import com.compose.ez.ui.api.Color
import com.compose.ez.ui.api.FontStyle
import com.compose.ez.ui.api.Length
import com.compose.ez.ui.api.Padding
import com.compose.ez.ui.api.TextSpan
import com.compose.ez.ui.widget.Image
import com.compose.ez.ui.widget.Text

/**
 * author: wulinpeng
 * date: 2024/3/26
 * desc:
 */
class AndroidImage(private val context: Context): Image<View> {

  private val innerView = AppCompatImageView(context)
  private var url: String? = null
  private var circle: Boolean = false

  override fun url(url: String) {
    this.url = url
    updateImage()
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

  override fun circle(circle: Boolean) {
    this.circle = circle
    updateImage()
  }

  private fun updateImage() {
    Glide.with(innerView)
      .load(url)
      .let {
        if (circle) {
          it.circleCrop()
        } else {
          it
        }
      }
      .into(innerView)
  }

  override var modifier: Modifier = Modifier
  override val value: View= innerView
}
