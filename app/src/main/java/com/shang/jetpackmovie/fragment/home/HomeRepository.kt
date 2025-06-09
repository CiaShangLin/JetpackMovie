package com.shang.jetpackmovie.fragment.home

import com.shang.jetpackmovie.api.MovieApi

class HomeRepository(private val movieApi: MovieApi) {
    suspend fun getMovieGenres() = movieApi.getMovieGenres()
}
