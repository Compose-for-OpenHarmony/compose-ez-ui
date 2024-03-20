package weibo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.compose.ez.ui.compose.Column
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
    Text("Loading")
  } else if (vm.weiboList.isEmpty()) {
    Text("Empty")
  } else {
    Column {
      vm.weiboList.forEach {
        WeiboCard(it)
      }
    }
  }

}
