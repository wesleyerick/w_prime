package com.wesleyerick.wprime.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wesleyerick.wprime.model.Banner
import com.wesleyerick.wprime.model.Genres
import com.wesleyerick.wprime.repository.MainRepository
import kotlinx.coroutines.*

class MainViewModel(
    private val mainRepository: MainRepository
) : ViewModel() {

    val popularMoviesList = MutableLiveData<List<Banner>>()
    val upcomingMoviesList = MutableLiveData<List<Banner>>()
    val genres = MutableLiveData<Genres>()
    val popularTvList = MutableLiveData<List<Banner>>()
    val topRatedTvList = MutableLiveData<List<Banner>>()
    val queryResult = MutableLiveData<List<Banner>>()

    fun getPopularMovies() {
        CoroutineScope(Dispatchers.IO).launch {
                val response = mainRepository.getPopularMovies()

                if (response.isSuccessful) {
                    println("=====> getPopularMovies -> ${response.body()}")
                    popularMoviesList.postValue(response.body()?.results)
                } else {
                    println("=====> Retrofit ${response.message()}")
                }
            }
    }

    fun getUpcomingMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = mainRepository.getUpcomingMovies()

            if (response.isSuccessful) {
                println("=====> getUpcomingMovies -> ${response.body()}")
                upcomingMoviesList.postValue(response.body()?.results)
            } else {
                println("=====> Retrofit ${response.message()}")
            }
        }
    }


    fun getGenres(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = mainRepository.getGenres()

            if (response.isSuccessful) {
                println("=====> getGenres -> ${response.body()}")
                genres.postValue(response.body())
            } else {
                println("=====> Retrofit ${response.message()}")
            }
        }
    }



    fun getPopularTV() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = mainRepository.getPopularTV()

            if (response.isSuccessful) {
                println("=====> getPopularMovies -> ${response.body()}")
                popularTvList.postValue(response.body()?.results)
            } else {
                println("=====> Retrofit ${response.message()}")
            }
        }
    }

    fun getTopRatedTV(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = mainRepository.getTopRatedTV()

            if (response.isSuccessful) {
                println("=====> getPopularMovies -> ${response.body()}")
                topRatedTvList.postValue(response.body()?.results)
            } else {
                println("=====> Retrofit ${response.message()}")
            }
        }
    }

    fun query(query: String){
        CoroutineScope(Dispatchers.IO).launch {
            val response = mainRepository.query(query)

            if (response.isSuccessful) {
                println("=====> query -> ${response.body()}")
                queryResult.postValue(response.body()?.results)
            } else {
                println("=====> Retrofit ${response.message()}")
            }
        }
    }

    fun queryByGenre(id: String){
        CoroutineScope(Dispatchers.IO).launch {
            val response = mainRepository.queryByGenre(id)

            if (response.isSuccessful) {
                println("=====> queryByGenre -> ${response.body()}")
                queryResult.postValue(response.body()?.results)
            } else {
                println("=====> Retrofit ${response.message()}")
            }
        }
    }

    fun initApp() {
        getPopularMovies()
        getPopularTV()
        getTopRatedTV()
        getUpcomingMovies()
        getGenres()
    }
}