package com.shang.jetpackmovie.core

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shang.jetpackmovie.globalData.UserSetting
import com.shang.jetpackmovie.room.MovieDatabase
import com.shang.jetpackmovie.utils.LocaleHelper
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import java.util.*

class JetpackMovieApplication : MultiDexApplication() {


    companion object {
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()

        context = this
        AppCompatDelegate.setDefaultNightMode(UserSetting.theme)

        startKoin {
            androidLogger()
            androidContext(this@JetpackMovieApplication)
            modules(
                roomModule,
                networkModule,
                homeViewModelModule,
                favorViewModelModule,
                settingViewModel,
                splashViewModelModule,
                genresViewModule,
                detailViewModel
            )
        }


    }
}