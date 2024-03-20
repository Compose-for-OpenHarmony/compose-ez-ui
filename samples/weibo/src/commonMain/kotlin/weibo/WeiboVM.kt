package weibo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.serialization.json.Json

/**
 * author: wulinpeng
 * date: 2024/2/19
 * desc:
 */
class WeiboVM {
  var isLoading by mutableStateOf(true)
  var weiboList = mutableStateListOf<WeiboModel>()

  private val json = Json { ignoreUnknownKeys = true }

  suspend fun fetchWeiboList() {
    isLoading = true
    val response = json.decodeFromString<WeiboResponse>(WeiboRepo.fakeData)
    response.weibo.forEach {
      it.user_name = response.user.screen_name
      it.avatar_url = response.user.profile_image_url
    }
    weiboList.addAll(response.weibo)
    isLoading = false
  }
}
