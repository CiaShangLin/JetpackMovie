package com.shang.jetpackmovie.activity.detail

import com.shang.jetpackmovie.bean.IBaseMovie
import com.shang.jetpackmovie.room.dao.MovieFavorDao
import com.shang.jetpackmovie.room.entity.MovieFavorEntity

class DetailRepository(private val movieFavorDao:MovieFavorDao) {

    fun insert(movieResult: IBaseMovie){
        movieFavorDao.insertMovieFavor(MovieFavorEntity.convert(movieResult))
    }

    fun delete(movieResult: IBaseMovie){
        movieFavorDao.deleteMovieFavor(MovieFavorEntity.convert(movieResult))
    }

    fun isFavorites(id:Int) = movieFavorDao.isFavorites(id)
}