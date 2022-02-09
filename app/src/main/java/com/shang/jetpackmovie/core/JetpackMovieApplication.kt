package com.shang.jetpackmovie.core

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDexApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class JetpackMovieApplication : MultiDexApplication() {


    companion object {
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()

        context = this

        startKoin {
            androidLogger()
            androidContext(this@JetpackMovieApplication)
            modules(networkModule, homeViewModelModule, splashViewModelModule)
        }
    }
}