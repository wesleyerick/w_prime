package com.wesleyerick.wprime.ui.navigation

sealed class Screen(val route: String) {
    object MainScreen: Screen("main_screen")
    object BannerDetailScreen: Screen("banner_main_screen")

    fun withArgs(vararg args: String): String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
