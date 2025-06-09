package com.shang.jetpackmovie.activity.detail

import com.shang.jetpackmovie.api.MovieApi
import com.shang.jetpackmovie.bean.ActorBean
import com.shang.jetpackmovie.bean.IBaseMovie
import com.shang.jetpackmovie.bean.MovieDetailBean
import com.shang.jetpackmovie.bean.MovieListBean
import com.shang.jetpackmovie.room.dao.MovieFavorDao
import com.shang.jetpackmovie.room.entity.MovieFavorEntity

interface DetailApi {
    suspend fun getMovieDetail(id: Int): MovieDetailBean
    suspend fun getMovieActor(id: Int): ActorBean
    suspend fun getMovieRecommendations(id: Int): MovieListBean
}

class DetailApiImp(private val movieApi: MovieApi) : DetailApi {
    override suspend fun getMovieDetail(id: Int) = movieApi.getMovieDetail(id)

    override suspend fun getMovieActor(id: Int) = movieApi.getMovieActor(id)

    override suspend fun getMovieRecommendations(id: Int) = movieApi.getMovieRecommendations(id)
}

/**
 * 使用DetailApi而不是直接使用MovieApi是因為如果要測試的話
 * 我只需要自己在new一個class去實作DetailApi就可以做到給假資料測試
 * 可惜這裡沒有做什麼map之類的轉換操作所以就不寫測試了
 */
class DetailRepository(
    private val movieApi: DetailApiImp,
    private val movieFavorDao: MovieFavorDao,
) {

    suspend fun getMovieDetail(id: Int) = movieApi.getMovieDetail(id)

    suspend fun getMovieActor(id: Int) = movieApi.getMovieActor(id)

    suspend fun getMovieRecommendations(id: Int) = movieApi.getMovieRecommendations(id)

    fun insert(movieResult: IBaseMovie) {
        movieFavorDao.insertMovieFavor(MovieFavorEntity.convert(movieResult))
    }

    fun delete(movieResult: IBaseMovie) {
        movieFavorDao.deleteMovieFavor(MovieFavorEntity.convert(movieResult))
    }

    fun isFavorites(id: Int) = movieFavorDao.isFavorites(id)
}
