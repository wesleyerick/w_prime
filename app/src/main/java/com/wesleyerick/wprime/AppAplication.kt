package com.wesleyerick.wprime

import android.app.Application
import com.wesleyerick.wprime.di.apiModule
import com.wesleyerick.wprime.di.databaseModule
import com.wesleyerick.wprime.di.repositoryModule
import com.wesleyerick.wprime.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AppAplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@AppAplication)
            modules(viewModelModule, repositoryModule, databaseModule, apiModule)
        }
    }
}