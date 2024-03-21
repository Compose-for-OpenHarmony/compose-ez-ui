import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import app.cash.redwood.Modifier
import app.cash.redwood.ui.dp
import com.compose.ez.ui.api.Color
import com.compose.ez.ui.api.FontStyle
import com.compose.ez.ui.api.Length
import com.compose.ez.ui.api.Padding
import com.compose.ez.ui.api.TextSpan
import com.compose.ez.ui.compose.Button
import com.compose.ez.ui.compose.Column
import com.compose.ez.ui.compose.Image
import com.compose.ez.ui.compose.Row
import com.compose.ez.ui.compose.Text

/**
 * author: wulinpeng
 * date: 2024/1/28
 * desc:
 */
@Composable
fun Counter(value: Int = 0) {
  var count by remember { mutableStateOf(0) }

  Column(
    Length.Fill, Length.Fill,
    padding = Padding(10.dp, 10.dp, 10.dp)
  ) {
    Row(Length.Fill, Length.Wrap, padding = Padding(10.dp, 10.dp, 10.dp)) {
      Button("Add", onClick = { count++ })
      Text("Count is $count")
    }
  }
}
