import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import app.cash.redwood.Modifier
import app.cash.redwood.ui.dp
import com.redwood.ui.schema.api.Color
import com.redwood.ui.schema.api.FontStyle
import com.redwood.ui.schema.api.Length
import com.redwood.ui.schema.api.Padding
import com.redwood.ui.schema.api.TextSpan
import com.redwood.ui.schema.compose.Button
import com.redwood.ui.schema.compose.Column
import com.redwood.ui.schema.compose.Image
import com.redwood.ui.schema.compose.Row
import com.redwood.ui.schema.compose.Text

/**
 * author: wulinpeng
 * date: 2024/1/28
 * desc:
 */
@Composable
fun Counter(value: Int = 0) {
  var textCount by remember { mutableStateOf(0) }
  var count by remember { mutableStateOf(0) }
  var fontStyle by remember { mutableStateOf(FontStyle.Normal) }

  Column(
    Length.Fill, Length.Fill,
    padding = Padding(10.dp, 10.dp, 10.dp)
  ) {
    Row(Length.Fill, Length.Wrap) {
      Button("Add a text", onClick = { textCount++ })
      Button("Change font style", onClick = {
        if (fontStyle == FontStyle.Italic) {
          fontStyle = FontStyle.Normal
        } else {
          fontStyle = FontStyle.Italic
        }
      })
      Button("-1", onClick = { count-- })
      Button("+1", onClick = { count++ })
    }
    val imageSrc = "http://ww4.sinaimg.cn/bmiddle/001Ur7cfly1hm4vgxrc8mj6087065gm202.jpg"
    Image(imageSrc, Length(40.dp), Length(40.dp), circle = true)
    for (i in 0..textCount) {
      Text("Count: $count",
        fontStyle = fontStyle,
        fontColor = Color.Blue,
        fontSize = 30.dp,
        spans = listOf(
          TextSpan(0, 4, Color.Blue, 40.dp, FontStyle.Italic),
          TextSpan(7, 7, Color.Red, 50.dp, FontStyle.Normal)
        ),
        modifier = Modifier.weight(1f))
    }
  }

}
