package com.shang.jetpackmovie.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MovieFavorEntity")
data class MovieFavorEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val poster_path: String,
    val vote_average: Double,
    val release_date: String
)