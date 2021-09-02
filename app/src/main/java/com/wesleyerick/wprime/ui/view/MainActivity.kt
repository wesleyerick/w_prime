package com.wesleyerick.wprime.ui.view

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import com.wesleyerick.wprime.model.Banner
import com.wesleyerick.wprime.model.Genres
import com.wesleyerick.wprime.ui.component.*
import com.wesleyerick.wprime.ui.theme.WPrimeTheme
import com.wesleyerick.wprime.util.mockList
import com.wesleyerick.wprime.util.mockMenuItems
import com.wesleyerick.wprime.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<MainViewModel>()

    private lateinit var popularMovies: List<Banner>
    private lateinit var upcomingMovies: List<Banner>
    private lateinit var menuItems: Genres
    private lateinit var popularTv: List<Banner>
    private lateinit var topRatedTv: List<Banner>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.initApp()

        setContent {

            var popularMoviesReady by remember { mutableStateOf(false) }
            var upcomingMoviesReady by remember { mutableStateOf(false) }
            var menuReady by remember { mutableStateOf(false) }
            var popularTvReady by remember { mutableStateOf(false) }
            var topRatedTvReady by remember { mutableStateOf(false) }

            WPrimeTheme {
                if (
                    popularMoviesReady &&
                    menuReady &&
                    upcomingMoviesReady &&
                    popularTvReady &&
                    topRatedTvReady
                ) {
                    BaseScreen(popularMovies, upcomingMovies, menuItems, popularTv, topRatedTv)
                } else {
                    SplashScreen()
                }
            }

            val popularMoviesListObserver = Observer<List<Banner>> {
                popularMovies = it
                popularMoviesReady = true
            }
            viewModel.popularMoviesList.observe(this, popularMoviesListObserver)

            val upcomingObserver = Observer<List<Banner>> {
                upcomingMovies = it
                upcomingMoviesReady = true
            }
            viewModel.upcomingMoviesList.observe(this, upcomingObserver)

            val genresObserver = Observer<Genres> {
                menuItems = it
                menuReady = true
            }
            viewModel.genres.observe(this, genresObserver)

            val popularTvListObserver = Observer<List<Banner>> {
                popularTv = it
                popularTvReady = true
            }
            viewModel.popularTvList.observe(this, popularTvListObserver)

            val topRatedListObserver = Observer<List<Banner>> {
                topRatedTv = it
                topRatedTvReady = true
            }
            viewModel.topRatedTvList.observe(this, topRatedListObserver)
        }
    }
}

@Composable
fun BaseScreen(
    popularMovies: List<Banner>,
    upcomingMovies: List<Banner>,
    menuItems: Genres,
    popularTv: List<Banner>,
    topRatedTv: List<Banner>
) {

    var isMenuOpened by remember { mutableStateOf(false) }

    val topBannerNumber = (popularMovies.indices).random()

    Surface(color = Color.Black) {
        Row {
            SideMenu(isMenuOpened = isMenuOpened, menuItems, modifier = Modifier.clickable {  }) // TODO parei aqui

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(enabled = true, state = ScrollState(0)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BannerTop(popularMovies[topBannerNumber], isMenuOpened)
                BannerRow(popularTv, "Séries em Alta")
                BannerRow(popularMovies, "Filmes em Alta")
                BannerRow(upcomingMovies, "Lançamentos")
                BannerRow(topRatedTv, "Séries bem avaliadas")
            }
        }
        TopBarWPrime(modifier = Modifier
            .size(40.dp)
            .clickable { isMenuOpened = !isMenuOpened })
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
fun DefaultPreview() {
    WPrimeTheme {
        BaseScreen(mockList, mockList, Genres(mockMenuItems), mockList, mockList)
    }
}