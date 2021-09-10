package com.wesleyerick.wprime.ui.view

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.wesleyerick.wprime.R
import com.wesleyerick.wprime.model.Banner
import com.wesleyerick.wprime.ui.component.BannerTop
import com.wesleyerick.wprime.util.mockList

@Composable
fun BannerDetailsScreen(
    navController: NavController,
    banner: Banner
){

    Surface(color = Color.Black, modifier = Modifier.fillMaxSize()) {
        Column {
            BannerTop(
                banner = banner,
                isMenuOpened = true
            )
            Text(
                text = banner.title.toString(),
                color = Color.White,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(all = 16.dp)
            )
            Row {
                StarRating(8.5)
            }
            Text(
                text = banner.overview.toString(),
                color = Color.White,
                modifier = Modifier.padding(all = 16.dp)
            )
        }
    }
}

@Composable
fun StarRating(rating: Double) {
    var list: List<Boolean>
    val n = 0

    Row(modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
        Image(painter = painterResource(id = R.drawable.ic_star_visible), contentDescription = "Star Rating")
        Image(painter = painterResource(id = R.drawable.ic_star_visible), contentDescription = "Star Rating")
        Image(painter = painterResource(id = R.drawable.ic_star_visible), contentDescription = "Star Rating")
        Image(painter = painterResource(id = R.drawable.ic_star_visible), contentDescription = "Star Rating")
        Image(painter = painterResource(id = R.drawable.ic_star_gone), contentDescription = "Star Rating")
        Text(text = rating.toString())
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
fun BannerDetailsPreview(){
    BannerDetailsScreen(rememberNavController() ,mockList.first())

}
