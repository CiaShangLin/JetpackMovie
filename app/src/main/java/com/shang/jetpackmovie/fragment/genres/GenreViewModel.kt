package com.shang.jetpackmovie.fragment.genres

import android.util.Log
import androidx.lifecycle.*
import com.google.gson.Gson
import com.shang.jetpackmovie.api.UiState
import com.shang.jetpackmovie.bean.IBaseMovie
import com.shang.jetpackmovie.bean.MovieGenreBean
import com.shang.jetpackmovie.bean.MovieListBean
import com.shang.jetpackmovie.epoxy.BaseMovieModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GenreViewModel(
    private val genre: MovieGenreBean.Genre?,
    private val genreRepository: GenreRepository
) : ViewModel(), BaseMovieModel.MovieFavorListener {

    private var _path = 1
    private val _genreLiveData = MutableLiveData<UiState<MovieListBean>>()

    val genreLiveData = liveData<UiState<MovieListBean>> {
        try {
            val bean = genreRepository.getMovieGenreDetail("${genre?.id}", _path)
            emit(UiState.success(bean))
        } catch (e: Exception) {
            emit(UiState.failure(e))
            e.printStackTrace()
        }
    }.switchMap {
        _genreLiveData.value = it
        _genreLiveData
    }

    fun refresh() {
        _path = 1
        getMovieListApi()
    }

    fun loadMore() {
        if(_genreLiveData.value is UiState.Loading){
            return
        }
        _path++
        getMovieListApi()
    }

    private fun getMovieListApi() {
        viewModelScope.launch {
            _genreLiveData.value = UiState.loading()
            try {
                delay(1000)
                val bean = genreRepository.getMovieGenreDetail("${genre?.id}", _path)
                _genreLiveData.value = UiState.success(bean)
            } catch (e: Exception) {
                _genreLiveData.value = UiState.failure(e)
                e.printStackTrace()
            }
        }
    }

    override fun isFavorites(id: Int) = genreRepository.isFavorites(id)

    override fun insert(data: IBaseMovie) = genreRepository.insert(data)

    override fun delete(data: IBaseMovie) = genreRepository.delete(data)
}