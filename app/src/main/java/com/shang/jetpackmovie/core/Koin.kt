package com.shang.jetpackmovie.core

import android.app.Application
import androidx.room.Room
import com.shang.jetpackmovie.activity.detail.DetailRepository
import com.shang.jetpackmovie.activity.detail.DetailViewModel
import com.shang.jetpackmovie.activity.splash.SplashRepository
import com.shang.jetpackmovie.activity.splash.SplashViewModel
import com.shang.jetpackmovie.api.AuthInterceptor
import com.shang.jetpackmovie.api.LanguageInterceptor
import com.shang.jetpackmovie.api.MovieApi
import com.shang.jetpackmovie.fragment.favor.FavorRepository
import com.shang.jetpackmovie.fragment.favor.FavorViewModel
import com.shang.jetpackmovie.fragment.genres.GenreRepository
import com.shang.jetpackmovie.fragment.genres.GenreViewModel
import com.shang.jetpackmovie.fragment.home.HomeRepository
import com.shang.jetpackmovie.fragment.home.HomeViewModel
import com.shang.jetpackmovie.fragment.setting.SettingRepository
import com.shang.jetpackmovie.fragment.setting.SettingViewModel
import com.shang.jetpackmovie.room.MovieDatabase
import com.shang.jetpackmovie.room.dao.MovieFavorDao
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val roomModule = module {

    fun provideDataBase(application: Application): MovieDatabase {
        return Room
            .databaseBuilder(application, MovieDatabase::class.java, MovieDatabase.DB_NAME)
            .allowMainThreadQueries()
            .build()
    }

    fun provideMovieFavorDao(dataBase: MovieDatabase): MovieFavorDao {
        return dataBase.movieFavorDao()
    }

    single {
        provideDataBase(androidApplication())
    }

    single {
        provideMovieFavorDao(get())
    }
}

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
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
            .addInterceptor(AuthInterceptor())
            .addInterceptor(LanguageInterceptor())
            .build()
    }

    factory {
        (get() as Retrofit).create(MovieApi::class.java)
    }
}

val homeViewModelModule = module {
    viewModel {
        HomeViewModel(get())
    }
    single {
        HomeRepository(get())
    }
}

val favorViewModelModule = module {
    viewModel {
        FavorViewModel(get())
    }
    single {
        FavorRepository(get())
    }
}

val settingViewModel = module {
    viewModel{
        SettingViewModel(get())
    }
    single {
        SettingRepository()
    }
}


val splashViewModelModule = module {
    viewModel {
        SplashViewModel(this.androidApplication(), get())
    }
    single {
        SplashRepository(get())
    }
}

val genresViewModule = module {
    viewModel { parameters ->
        GenreViewModel(parameters.get(), get())
    }


    single {
        GenreRepository(get(),get())
    }
}

val detailViewModel = module {
    viewModel {
        DetailViewModel(get())
    }

    single {
        DetailRepository(get())
    }
}