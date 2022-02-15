package com.shang.jetpackmovie.fragment.genres

import com.shang.jetpackmovie.api.MovieApi
import com.shang.jetpackmovie.bean.IBaseMovie
import com.shang.jetpackmovie.bean.MovieListBean
import com.shang.jetpackmovie.room.dao.MovieFavorDao
import com.shang.jetpackmovie.room.entity.MovieFavorEntity

class GenreRepository(private val movieApi: MovieApi,private val movieFavorDao:MovieFavorDao) {
    suspend fun getMovieGenreDetail(genreId: String, path: Int) =
        movieApi.getMovieGenreDetail(genreId, path)

    fun insert(movieResult:IBaseMovie){
        movieFavorDao.insertMovieFavor(MovieFavorEntity.convert(movieResult))
    }

    fun delete(movieResult:IBaseMovie){
        movieFavorDao.deleteMovieFavor(MovieFavorEntity.convert(movieResult))
    }

    fun isFavorites(id:Int) = movieFavorDao.isFavorites(id)
}