package com.example.mobsofthw

import android.app.Application
import com.example.mobsofthw.di.localSourceModule
import com.example.mobsofthw.di.newsModule
import com.example.mobsofthw.di.remoteSourceModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NewsApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@NewsApp)
            modules(newsModule + remoteSourceModule + localSourceModule)
        }
    }
}