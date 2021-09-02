package com.wesleyerick.wprime.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wesleyerick.wprime.R

@Composable
fun SplashScreen(){
//    Box(
//        modifier = Modifier.fillMaxSize(),
//    ) {
        Row(
            modifier = Modifier.fillMaxSize().padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.w2),
                contentDescription = "Logo",
                modifier = Modifier.size(70.dp)
            )
            Text(
                text = "Prime",
                modifier = Modifier.padding(start = 8.dp),
                color = MaterialTheme.colors.primaryVariant,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h2,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.ExtraBold
            )
        }
//    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun SplashPreview(){
    SplashScreen()
}