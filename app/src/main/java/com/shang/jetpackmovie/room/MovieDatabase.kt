package com.shang.jetpackmovie.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.shang.jetpackmovie.room.dao.MovieFavorDao
import com.shang.jetpackmovie.room.entity.MovieFavorEntity

@Database(entities = [MovieFavorEntity::class], version = 2)
abstract class MovieDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "MovieDatabase"
    }

    abstract fun movieFavorDao(): MovieFavorDao
}

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE MovieFavorEntity ADD COLUMN timestamp INTEGER NOT NULL DEFAULT 0")
    }
}
