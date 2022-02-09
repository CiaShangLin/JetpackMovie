package com.shang.jetpackmovie.api

import android.graphics.Movie
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService : KoinComponent {
    private val retrofit: Retrofit by inject()

    val movieApi :MovieApi by inject()
}