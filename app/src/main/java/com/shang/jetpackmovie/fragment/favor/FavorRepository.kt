package com.shang.jetpackmovie.fragment.favor

import com.shang.jetpackmovie.bean.IBaseMovie
import com.shang.jetpackmovie.room.dao.MovieFavorDao
import com.shang.jetpackmovie.room.entity.MovieFavorEntity

class FavorRepository(private val movieFavorDao: MovieFavorDao) {

    fun getAll() = movieFavorDao.getAllMovieFavor()

    fun insert(movieResult: IBaseMovie) {
        movieFavorDao.insertMovieFavor(MovieFavorEntity.convert(movieResult))
    }

    fun delete(movieResult: IBaseMovie) {
        movieFavorDao.deleteMovieFavor(MovieFavorEntity.convert(movieResult))
    }

    fun isFavorites(id: Int) = movieFavorDao.isFavorites(id)
}
