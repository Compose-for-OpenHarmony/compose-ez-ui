@file:JsModule(DOM_PACKAGE)
package harmony

import harmony.dom.DOM_PACKAGE

/**
 * author: wulinpeng
 * date: 2024/1/28
 * desc:
 */
public open external class FrameCallback {
  fun onNextFrame(callback: (Number) -> Unit)
}
