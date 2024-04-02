package weibo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.compose.ez.ui.api.Length
import com.compose.ez.ui.compose.Text

/**
 * author: wulinpeng
 * date: 2024/2/19
 * desc:
 */
@Composable
fun WeiboList() {
  val vm = remember { WeiboVM() }

  LaunchedEffect(Unit) {
    vm.fetchWeiboList()
  }

  if (vm.isLoading) {
    Text("Loading", width = Length.Fill, height = Length.Fill, textCenter = true)
  } else if (vm.weiboList.isEmpty()) {
    Text("Empty", width = Length.Fill, height = Length.Fill, textCenter = true)
  } else {
    com.compose.ez.ui.compose.List {
      vm.weiboList.forEach {
        WeiboCard(it)
      }
    }
  }
}
