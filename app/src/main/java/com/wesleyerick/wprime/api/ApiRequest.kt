package com.wesleyerick.wprime.api


////    suspend fun <T : Any> apiRequest(call: suspend () -> Call<T>): T {
//
//suspend fun apiRequest() {
//
//    val retrofit = Retrofit.Builder()
//        .baseUrl(ApiConst.endpoint)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    val service = retrofit.create(ApiService::class.java)
//
//    val callback = service.getPopularMovies(
//        api_key = ApiConst.api_key,
//        language = ApiConst.language,
//        page = ApiConst.page
//    )
//    callback.enqueue(object : Callback<PopularBanners> {
//        override fun onResponse(call: Call<PopularBanners>, response: Response<PopularBanners>) {
//            response.body().let {
//                println("=====> teste sucesso -> $it / ${call.request()}")
//            }
//        }
//
//        override fun onFailure(call: Call<PopularBanners>, t: Throwable) {
//            println("=====> erro api ${t.message} / ${call.request()}")
//        }
//
//    })
//}
