package harmony

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MonotonicFrameClock
import app.cash.redwood.compose.RedwoodComposition
import harmony.HarmonyWidgetFactory
import com.redwood.ui.schema.widget.SchemaWidgetFactories
import harmony.dom.BaseNode
import harmony.dom.ColumnNode
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.plus

/**
 * author: wulinpeng
 * date: 2024/1/28
 * desc:
 */
class CreateHarmonyNode {
  fun createNode(content: @Composable () -> Unit): BaseNode {
    val rootNode = ColumnNode()

    @OptIn(DelicateCoroutinesApi::class)
    val composition = RedwoodComposition(
      scope = GlobalScope + HarmonyFrameClock,
      view = RedwoodHarmonyView(rootNode),
      provider = SchemaWidgetFactories(
        Schema = HarmonyWidgetFactory()
      ),
    )
    composition.setContent {
      content()
    }
    return rootNode
  }
}

public object HarmonyFrameClock : MonotonicFrameClock {
  override suspend fun <R> withFrameNanos(
    onFrame: (Long) -> R,
  ): R = suspendCoroutine { continuation ->
    FrameCallback().onNextFrame {
      val durationNanos = it.toLong() * 1000000
      val result = onFrame(durationNanos)
      continuation.resume(result)
    }
  }
}
