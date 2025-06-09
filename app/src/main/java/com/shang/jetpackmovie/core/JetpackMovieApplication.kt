package com.shang.jetpackmovie.core

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import com.shang.jetpackmovie.globalData.UserSetting
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
                detailViewModel,
            )
        }
    }
}
