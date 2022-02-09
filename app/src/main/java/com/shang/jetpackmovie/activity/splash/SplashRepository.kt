package com.shang.jetpackmovie.activity.splash

import com.shang.jetpackmovie.api.MovieApi

class SplashRepository(private val movieApi: MovieApi) {

    suspend fun getConfiguration() = movieApi.getConfiguration()
}