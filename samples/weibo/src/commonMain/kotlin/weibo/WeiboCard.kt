package weibo

import androidx.compose.runtime.Composable
import app.cash.redwood.Modifier
import app.cash.redwood.ui.dp
import com.compose.ez.ui.api.Color
import com.compose.ez.ui.api.Length
import com.compose.ez.ui.api.Padding
import com.compose.ez.ui.compose.Column
import com.compose.ez.ui.compose.Image
import com.compose.ez.ui.compose.Row
import com.compose.ez.ui.compose.Text

/**
 * author: wulinpeng
 * date: 2024/2/19
 * desc:
 */
@Composable
fun WeiboCard(weiboModel: WeiboModel) {
  Column {
    Row(padding = Padding(10.dp, 10.dp, 10.dp, 10.dp)) {
      Image(weiboModel.avatar_url, Length(40.dp), Length(40.dp), circle = true)
      Column(padding = Padding(10.dp), modifier = Modifier.weight(1f)) {
        Text(weiboModel.user_name, fontSize = 16.dp, fontColor = Color.Orange)
        Row {
          Text(weiboModel.created_at, fontSize = 10.dp, fontColor = Color.Grey)
          Text(weiboModel.source, fontSize = 10.dp, fontColor = Color.Grey)
        }
      }
    }
    // TODO Spans
    Text(weiboModel.text, maxLines = 5, padding = Padding(start = 10.dp, end = 10.dp))
    // TODO Grid
    Image(weiboModel.pics.split(",").first(), Length(200.dp), Length(200.dp))
  }
}
