package harmony

import app.cash.redwood.ui.toPlatformDp
import com.redwood.ui.schema.api.Length
import com.redwood.ui.schema.api.Padding
import harmony.dom.BaseNode

/**
 * author: wulinpeng
 * date: 2024/1/27
 * desc:
 */
public fun BaseNode.setWidthLength(width: Length) {
  when (width) {
      Length.Fill -> {
        setWidthString("100%")
      }
      Length.Wrap -> {
        setWidthString("auto")
      }
      else -> {
        setWidthString("")
        setWidth(width.dp.toPlatformDp())
      }
  }
}

public fun BaseNode.setHeightLength(height: Length) {
  when (height) {
      Length.Fill -> {
        setHeightString("100%")
      }
      Length.Wrap -> {
        setHeightString("auto")
      }
      else -> {
        setHeightString("")
        setHeight(height.dp.toPlatformDp())
      }
  }
}

public fun BaseNode.setPaddingLength(padding: Padding) {
  setPadding(
    padding.start?.toPlatformDp(), padding.top?.toPlatformDp(),
    padding.end?.toPlatformDp(), padding.bottom?.toPlatformDp()
  )
}
