package com.shang.jetpackmovie.bean

import java.io.Serializable

data class BaseMovieBean(
    val id: Int,
    val title: String,
    val poster_path: String,
    val vote_average: Double,
    val release_date: String
) : IBaseMovie, Serializable {

    companion object {
        fun convert(data: IBaseMovie): BaseMovieBean {
            return BaseMovieBean(
                data.getMovieID(),
                data.getMovieTitle(),
                data.getPosterPath(),
                data.getVoteAverage(),
                data.getReleaseDate()
            )
        }
    }

    override fun getMovieID(): Int = id

    override fun getMovieTitle(): String = title

    override fun getPosterPath(): String = poster_path

    override fun getVoteAverage(): Double = vote_average

    override fun getReleaseDate(): String = release_date


}