package com.wesleyerick.wprime.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitManager {

    val retrofitBuilder: ApiService = Retrofit.Builder()
        .baseUrl(ApiConst.endpoint)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(ApiService::class.java)
}