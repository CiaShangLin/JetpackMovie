package com.shang.jetpackmovie.fragment.genres

import com.shang.jetpackmovie.api.MovieApi

class GenreRepository(private val movieApi: MovieApi) {
    suspend fun getMovieGenreDetail(genreId: String, path: Int) =
        movieApi.getMovieGenreDetail(genreId, path)
}