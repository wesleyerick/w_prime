package com.wesleyerick.wprime.repository

import com.wesleyerick.wprime.api.ApiConst
import com.wesleyerick.wprime.api.ApiService
import com.wesleyerick.wprime.model.Genres
import com.wesleyerick.wprime.model.Banners
import com.wesleyerick.wprime.model.UpcomingBanners
import retrofit2.Response

open class MainRepository(
    private val api: ApiService,
    private val const: ApiConst,
) {
    open suspend fun getPopularMovies(): Response<Banners>{
        return api.getPopularMovies(
            api_key = const.api_key,
            language = const.language,
            page = const.page
        )
    }

    suspend fun getUpcomingMovies(): Response<UpcomingBanners>{
        return api.getUpcomingMovies(
            api_key = const.api_key,
            language = const.language,
            page = const.page
        )
    }

    suspend fun getGenres(): Response<Genres>{
        return api.getGenres(
            api_key = const.api_key,
            language = const.language,
            )
    }


    suspend fun getPopularTV(): Response<Banners>{
        return api.getPopularTV(
            api_key = const.api_key,
            language = const.language,
            page = const.page
        )
    }

    suspend fun getTopRatedTV(): Response<Banners>{
        return api.getTopRatedTV(
            api_key = const.api_key,
            language = const.language,
            page = const.page
        )
    }

    suspend fun query(query:String): Response<Banners>{
        return api.query(
            api_key = const.api_key,
            language = const.language,
            page = const.page,
            query = query
        )
    }

    suspend fun queryByGenre(id:String): Response<Banners>{
        return api.queryByGenre(
            api_key = const.api_key,
            language = const.language,
            page = const.page,
            with_genres = id
        )
    }
}