package com.shang.jetpackmovie.fragment.favor

import androidx.lifecycle.LiveData
import com.shang.jetpackmovie.room.dao.MovieFavorDao
import com.shang.jetpackmovie.room.entity.MovieFavorEntity

class FavorRepository(private val movieFavorDao: MovieFavorDao) {

    fun getAll(): LiveData<List<MovieFavorEntity>> {
        return movieFavorDao.getAllMovieFavor()
    }
}