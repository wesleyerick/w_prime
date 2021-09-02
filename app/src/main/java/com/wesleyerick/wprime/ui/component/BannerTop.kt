package com.wesleyerick.wprime.ui.component

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.wesleyerick.wprime.R
import com.wesleyerick.wprime.api.ApiConst
import com.wesleyerick.wprime.model.Banner
import com.wesleyerick.wprime.util.mockList

val bannerHeight = 500.dp

@Composable
fun BannerTop(banner: Banner, isMenuOpened: Boolean) {

    var isExpanded by remember { mutableStateOf(false) }



    Box(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
        Image(
            painter = rememberImagePainter("${ApiConst.images_endpoint}${banner.poster_path}"),
//            painter = painterResource(id = R.drawable.space_jam),
            contentDescription = "Big Banner",
            modifier = Modifier
                .fillMaxWidth()
                .height(bannerHeight),
            contentScale = ContentScale.Crop
        )
        GradientMask()

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .animateContentSize()
        ) {
            if (!isMenuOpened){
                Text(
                    text = banner.title.toString(),
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 16.dp)
                        .fillMaxWidth().animateContentSize(),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    style = MaterialTheme.typography.h4,
                    fontFamily = FontFamily.Cursive
                )

                Image(
                    painter = painterResource(
                        id = if (isExpanded) R.drawable.ic_baseline_expand_more_24 else R.drawable.ic_baseline_expand_less_24
                    ),
                    contentDescription = "Mais Informações",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )

                if (isExpanded) {
                    Text(
                        text = banner.overview.toString(),
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 16.dp)
                            .fillMaxWidth(),
//                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        style = MaterialTheme.typography.subtitle1,
                    )
                }
            }
        }

    }
}

@Composable
fun GradientMask() {
    Box(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black,
                    )
                )
            )
            .fillMaxWidth()
            .height(bannerHeight)
    )
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
fun PreviewBannerTop() {
    BannerTop(banner = mockList[0], isMenuOpened = false)
}