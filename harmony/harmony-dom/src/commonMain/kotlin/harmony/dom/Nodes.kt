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
public open external class TextNode: BaseNode {
  public fun setText(text: String)

  public fun setFontStyle(fontStyle: OhFontStyle)
}

public open external class ButtonNode: BaseNode {
  public var text: String
  public fun onClick(onClick: (() -> Unit)?)
}

public open external class ColumnNode: BaseNodeGroup

public open external class RowNode: BaseNodeGroup
