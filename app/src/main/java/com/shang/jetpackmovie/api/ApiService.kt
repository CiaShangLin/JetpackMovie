package com.shang.jetpackmovie.api

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Retrofit

object ApiService : KoinComponent {
    private val retrofit: Retrofit by inject()

    val movieApi: MovieApi by inject()
}
