package com.shang.jetpackmovie.activity.detail

import com.shang.jetpackmovie.api.MovieApi
import com.shang.jetpackmovie.bean.IBaseMovie
import com.shang.jetpackmovie.room.dao.MovieFavorDao
import com.shang.jetpackmovie.room.entity.MovieFavorEntity

class DetailRepository(private val movieApi: MovieApi, private val movieFavorDao: MovieFavorDao) {

    suspend fun getMovieDetail(id: Int) = movieApi.getMovieDetail(id)

    suspend fun getMovieActor(id:Int) = movieApi.getMovieActor(id)

    suspend fun getMovieRecommendations(id:Int) = movieApi.getMovieRecommendations(id)

    fun insert(movieResult: IBaseMovie) {
        movieFavorDao.insertMovieFavor(MovieFavorEntity.convert(movieResult))
    }

    fun delete(movieResult: IBaseMovie) {
        movieFavorDao.deleteMovieFavor(MovieFavorEntity.convert(movieResult))
    }

    fun isFavorites(id: Int) = movieFavorDao.isFavorites(id)
}