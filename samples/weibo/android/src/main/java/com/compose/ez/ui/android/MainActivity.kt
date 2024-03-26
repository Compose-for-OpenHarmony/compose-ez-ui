package com.compose.ez.ui.android

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.compose.ez.ui.android.builder.ezUIView
import weibo.WeiboList

/**
 * author: wulinpeng
 * date: 2024/3/26
 * desc:
 */
class MainActivity: AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(ezUIView(this) {
      WeiboList()
    }.apply {
      setBackgroundColor(Color.WHITE)
    })
  }
}
