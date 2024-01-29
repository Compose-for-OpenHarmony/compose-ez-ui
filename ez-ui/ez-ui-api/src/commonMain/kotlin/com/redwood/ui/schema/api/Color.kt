package com.redwood.ui.schema.api

/**
 * author: wulinpeng
 * date: 2024/1/29
 * desc: rgb or argb. "#ffffff", "#ff000000", "rgb(255, 100, 255)", "rgba(255, 100, 255, 0.5)"
 */
open class Color(val value: String) {
  object Black: Color("#000000")
  object Blue: Color("#0000ff")
  object Brown: Color("#a52a2a")
  object Gray: Color("#808080")
  object Grey: Color("#808080")
  object Green: Color("#008000")
  object Orange: Color("#ffa500")
  object Pink: Color("#ffc0cb")
  object Red: Color("#ff0000")
  object White: Color("#ffffff")
  object Yellow: Color("#ffff00")
  object Transparent: Color("rgba(0,0,0,0)")
}
