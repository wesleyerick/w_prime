package com.wesleyerick.wprime.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.wesleyerick.wprime.model.Banner
import com.wesleyerick.wprime.model.Genres
import com.wesleyerick.wprime.ui.navigation.Screen
import com.wesleyerick.wprime.ui.view.BannerDetailsScreen
import com.wesleyerick.wprime.ui.view.MainScreen

@Composable
fun Navigation(
    popularMovies: List<Banner>,
    upcomingMovies: List<Banner>,
    menuItems: Genres,
    popularTv: List<Banner>,
    topRatedTv: List<Banner>
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(
                navController = navController,
                popularMovies = popularMovies,
                upcomingMovies = upcomingMovies,
                menuItems = menuItems,
                popularTv = popularTv,
                topRatedTv = topRatedTv
            )
        }
        composable(
            route = Screen.BannerDetailScreen.route + "/{id}/{title}/{poster_path}/{overview}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                },
                navArgument("title") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                },
                navArgument("overview") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                },
                navArgument("poster_path") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                }
            )
        ) { entry ->
            BannerDetailsScreen(
                navController = navController,
                banner = Banner(
                    adult = null,
                    backdrop_path = null,
                    genre_ids = null,
                    id = entry.arguments?.getString("id")?.toInt(),
                    original_language = null,
                    original_title = null,
                    overview = entry.arguments?.getString("overview"),
                    popularity = null,
                    poster_path = "/${entry.arguments?.getString("poster_path")}",
                    release_date = null,
                    title = entry.arguments?.getString("title"),
                    video = null,
                    vote_average = null,
                    vote_count = null
                )
            )
        }
    }
}