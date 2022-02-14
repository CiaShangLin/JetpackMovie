package com.shang.jetpackmovie.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shang.jetpackmovie.room.dao.MovieFavorDao
import com.shang.jetpackmovie.room.entity.MovieFavorEntity

@Database(entities = [MovieFavorEntity::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "MovieDatabase"
    }

    abstract fun movieFavorDao(): MovieFavorDao
}