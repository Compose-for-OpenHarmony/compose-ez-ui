@file:JsModule(DOM_PACKAGE)

package harmony.dom

/**
 * author: wulinpeng
 * date: 2024/1/28
 * desc:
 */
public open external class BaseNode {
  public var parentNode: BaseNodeGroup?
  public fun setLayoutWeight(weight: Number)
  public fun setWidthString(width: String)
  public fun setWidth(width: Number)
  public fun setHeightString(height: String)
  public fun setHeight(height: Number)
  public fun setPadding(left: Number?, top: Number?, right: Number?, bottom: Number?)
}

public open external class BaseNodeGroup: BaseNode {
  public fun insert(index: Number, node: BaseNode)
  public fun move(fromIndex: Number, toIndex: Number, count: Number)
  public fun remove(index: Number, count: Number)
  public fun clear()
}
