package com.shang.jetpackmovie.core

import com.bumptech.glide.Glide
import com.shang.jetpackmovie.activity.splash.SplashRepository
import com.shang.jetpackmovie.activity.splash.SplashViewModel
import com.shang.jetpackmovie.api.AuthInterceptor
import com.shang.jetpackmovie.api.MovieApi
import com.shang.jetpackmovie.fragment.home.HomeRepository
import com.shang.jetpackmovie.fragment.home.HomeViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

val networkModule = module {

    //https://api.themoviedb.org/3/movie/550?api_key=90b44d4486f4ba2b48dbc22e2099b38b
    single {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
//            .addConverterFactory(ScalarsConverterFactory.create())
            .client(get())
            .build()
    }

    factory {
        OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor())
            .addInterceptor(AuthInterceptor())
            .build()
    }

    factory {
        (get() as Retrofit).create(MovieApi::class.java)
    }
}

val homeViewModelModule = module {
    factory {
        HomeViewModel(get())
    }
    single {
        HomeRepository(get())
    }
}

val splashViewModelModule = module {
    factory {
        SplashViewModel(this.androidApplication(),get())
    }
    single {
        SplashRepository(get())
    }
}