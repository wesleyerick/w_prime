package com.wesleyerick.wprime.ui.component

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wesleyerick.wprime.model.Genre
import com.wesleyerick.wprime.model.Genres
import com.wesleyerick.wprime.ui.theme.notSoDark
import com.wesleyerick.wprime.util.mockMenuItems


@Composable
fun SideMenu(isMenuOpened: Boolean, genres: Genres, modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .animateContentSize()
            .width(if (isMenuOpened) 200.dp else 0.dp)
    ) {
        LogoBackground()
        MenuItems(genres, modifier)
    }
}

@Composable
fun MenuItems(menuItems: Genres, modifier: Modifier) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(menuItems.genres) { menuItem ->
            MenuItem(menuItem, modifier)
        }
    }
}

@Composable
fun MenuItem(genre: Genre, modifier: Modifier) {
    Box(modifier = modifier) {
        Text(
            text = genre.name,
            color = Color.White,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}

@Composable
fun LogoBackground() {
    Surface(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth(),
        color = notSoDark
    ) {
        Text(
            text = "Prime",
            modifier = Modifier
                .padding(start = 56.dp, top = 8.dp)
                .fillMaxSize(),
            color = MaterialTheme.colors.primaryVariant,
            textAlign = TextAlign.Justify,
            style = MaterialTheme.typography.h4,
            fontFamily = androidx.compose.ui.text.font.FontFamily.Cursive,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun SideMenuPreview() {
    SideMenu(isMenuOpened = true, Genres(mockMenuItems), modifier = Modifier.clickable {  } )
}
