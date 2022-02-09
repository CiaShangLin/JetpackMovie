package com.shang.jetpackmovie.api

import com.shang.jetpackmovie.bean.ConfigurationBean
import com.shang.jetpackmovie.bean.MovieBean
import com.shang.jetpackmovie.bean.MovieGenreBean
import com.shang.jetpackmovie.bean.MovieListBean
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface MovieApi {

    @GET("genre/movie/list")
    suspend fun getMovieGenres(): MovieGenreBean

    @GET("movie/{id}}")
    suspend fun getMovieDetail(@Path("id") id: String): MovieBean

    @GET("discover/movie")
    suspend fun getMovieGenreDetail(
        @Query("with_genres") with_genres: String,
        @Query("page") page: Int
    ): MovieListBean


    @GET("configuration")
    suspend fun getConfiguration(): ConfigurationBean

    @GET
    fun getPicture(@Url url: String): Call<ResponseBody>
}