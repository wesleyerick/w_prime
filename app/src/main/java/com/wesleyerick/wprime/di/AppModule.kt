package com.wesleyerick.wprime.di

import com.wesleyerick.wprime.api.ApiConst
import com.wesleyerick.wprime.api.RetrofitManager
import com.wesleyerick.wprime.repository.MainRepository
import com.wesleyerick.wprime.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

val repositoryModule = module {
    single { MainRepository(get(), get()) }
}

val databaseModule = module {

}

val apiModule = module {
    single { RetrofitManager.retrofitBuilder }
    single { ApiConst }
}