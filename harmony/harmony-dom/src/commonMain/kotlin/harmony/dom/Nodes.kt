@file:JsModule(DOM_PACKAGE)
package harmony.dom

/**
 * author: wulinpeng
 * date: 2024/1/27
 * desc:
 */
public external enum class OhFontStyle {
  Normal, Italic
}
public open external class OhTextSpan {
  var startIndex: Number
  var endIndex: Number
  var fontColor: String
  var fontSize: Number
  var fontStyle: OhFontStyle
}
public open external class TextNode: BaseNode {
  public fun setText(text: String)

  public fun setFontStyle(fontStyle: OhFontStyle)

  public fun setFontColor(fontColor: String)

  public fun setFontSize(fontSize: Number)

  public fun setMaxLines(maxLines: Number)

  public fun setSpans(span: Array<OhTextSpan>)

  public fun setTextCenter(center: Boolean)
}

public open external class ButtonNode: BaseNode {
  public var text: String
  public fun onClick(onClick: (() -> Unit)?)
}

public open external class ImageNode: BaseNode {
  public fun setUrl(url: String)
  public fun setIsCircle(isCircle: Boolean)
}

public open external class DividerNode: BaseNode {
  public fun setBackgroundColor(color: String)
}

public open external class ColumnNode: BaseNodeGroup

public open external class RowNode: BaseNodeGroup
public open external class ListNode: BaseNodeGroup
