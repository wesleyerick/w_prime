package com.wesleyerick.wprime.api

import com.wesleyerick.wprime.model.Genres
import com.wesleyerick.wprime.model.Banners
import com.wesleyerick.wprime.model.UpcomingBanners
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ) : Response<Banners>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ) : Response<UpcomingBanners>

    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
    ) : Response<Genres>

    @GET("tv/popular")
    suspend fun getPopularTV(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Response<Banners>

    @GET("tv/top_rated")
    suspend fun getTopRatedTV(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Response<Banners>

    @GET("search/collection")
    suspend fun query(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int,
        @Query("query") query: String
    ): Response<Banners>

    @GET("discover/movie")
    suspend fun queryByGenre(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int,
        @Query("with_genres") with_genres: String
    ): Response<Banners>
}