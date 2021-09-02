package com.wesleyerick.wprime.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.wesleyerick.wprime.R
import com.wesleyerick.wprime.api.ApiConst.images_endpoint
import com.wesleyerick.wprime.model.Banner
import com.wesleyerick.wprime.util.mockList

@Composable
fun BannerRow(banners: List<Banner>, title: String) {
    Column {
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = title,
            modifier = Modifier.padding(start = 8.dp),
            style = MaterialTheme.typography.h6,
            color = Color.White
        )
        Spacer(modifier = Modifier.size(8.dp))
        LazyRow {
            items(banners) { banner ->
                BannerCard(banner) {
                    println("=====> TESTE BannerRow CLICK -> ${banner.id}")
                }
            }
        }
    }
}

@Composable
fun BannerCard(banner: Banner, onClick: () -> Unit) {
    Card(
        modifier =
        Modifier
            .padding(8.dp)
            .width(150.dp)
            .clickable { onClick }
    ) {
        Column {
            Image(
            painter = rememberImagePainter("$images_endpoint${banner.poster_path}"),
//                painter = painterResource(id = R.drawable.space_jam),
                contentScale = ContentScale.Crop,
                contentDescription = banner.title,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .clipToBounds()
            )
//            Text(
//                text = banner.title.toString(),
//                style = MaterialTheme.typography.subtitle2,
//                modifier = Modifier.padding(8.dp).fillMaxWidth(),
//                color = Color.White,
//                textAlign = TextAlign.Center
//            )
        }
    }
}

@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewBannerRow(){
    BannerRow(banners = mockList, title = "Recomendado")
}
