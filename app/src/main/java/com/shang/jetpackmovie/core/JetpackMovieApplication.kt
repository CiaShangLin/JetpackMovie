package com.shang.jetpackmovie.core

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDexApplication
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shang.jetpackmovie.room.MovieDatabase
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
            modules(
                roomModule,
                networkModule,
                homeViewModelModule,
                favorViewModelModule,
                splashViewModelModule,
                genresViewModule
            )
        }


    }
}