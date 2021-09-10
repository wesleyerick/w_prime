package com.wesleyerick.wprime.util

import androidx.compose.material.Text
import com.wesleyerick.wprime.model.Banner
import com.wesleyerick.wprime.model.Banners
import com.wesleyerick.wprime.model.Genre

val mockList = listOf(
    Banner(
        adult = false,
        backdrop_path = "",
        genre_ids = listOf(18, 23),
        id = 0,
        original_language = "",
        original_title = "",
        overview = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce sed libero nulla. Vestibulum eget tortor risus. Nunc non congue justo. Nulla luctus quam et pharetra varius. Donec mi mauris, consequat vel neque a, commodo efficitur augue. Vivamus sagittis molestie lorem non dignissim. Curabitur euismod volutpat ultrices. Quisque lorem dolor, vulputate sit amet ipsum sit amet, efficitur facilisis dolor.\n" +
                "\n" +
                "Vivamus tristique metus vehicula interdum vestibulum. In volutpat dui quis nulla facilisis tempus. Etiam lectus elit, interdum et suscipit quis, gravida a eros. Suspendisse non eleifend ante. Pellentesque viverra odio a dui vulputate auctor. Fusce congue, libero quis egestas dignissim, risus velit mollis diam, porttitor tempor ligula magna at diam. Cras ultricies lorem felis, in blandit mi commodo at. Proin et justo vel purus scelerisque iaculis. Morbi ut vulputate quam. Morbi eget vulputate velit. Integer est urna, pulvinar eget magna at, malesuada posuere arcu. Etiam sit amet euismod metus.",
        popularity = 10.0,
        poster_path = "",
        release_date = "",
        title = "Space Jam: O legado",
        video = false,
        vote_average = null,
        vote_count = 0
    ),
    Banner(
        adult = false,
        backdrop_path = "",
        genre_ids = listOf(18, 23),
        id = 1,
        original_language = "",
        original_title = "",
        overview = "",
        popularity = 10.0,
        poster_path = "",
        release_date = "",
        title = "Space Jam: O legado",
        video = false,
        vote_average = null,
        vote_count = 0
    ),
    Banner(
        adult = false,
        backdrop_path = "",
        genre_ids = listOf(18, 23),
        id = 2,
        original_language = "",
        original_title = "",
        overview = "",
        popularity = 10.0,
        poster_path = "",
        release_date = "",
        title = "Space Jam: O legado",
        video = false,
        vote_average = null,
        vote_count = 0
    )
)

val mockBanners = Banners(
    page = 1,
    results = listOf(
        Banner(
            adult = false,
            backdrop_path = "",
            genre_ids = listOf(18, 23),
            id = 0,
            original_language = "",
            original_title = "",
            overview = "",
            popularity = 10.0,
            poster_path = "",
            release_date = "",
            title = "Space Jam: O legado",
            video = false,
            vote_average = null,
            vote_count = 0
        ),
        Banner(
            adult = false,
            backdrop_path = "",
            genre_ids = listOf(18, 23),
            id = 1,
            original_language = "",
            original_title = "",
            overview = "",
            popularity = 10.0,
            poster_path = "",
            release_date = "",
            title = "Space Jam: O legado",
            video = false,
            vote_average = null,
            vote_count = 0
        ),
        Banner(
            adult = false,
            backdrop_path = "",
            genre_ids = listOf(18, 23),
            id = 2,
            original_language = "",
            original_title = "",
            overview = "",
            popularity = 10.0,
            poster_path = "",
            release_date = "",
            title = "Space Jam: O legado",
            video = false,
            vote_average = null,
            vote_count = 0
        )
    ),
    total_pages = 1,
    total_results = 3
)

val mockMenuItems = listOf(
    Genre(id = 1, "Aventura"),
    Genre(id = 1, "Ação"),
    Genre(id = 1, "Aventura"),
    Genre(id = 1, "Ação"),
    Genre(id = 1, "Aventura"),
    Genre(id = 1, "Ação"),
)