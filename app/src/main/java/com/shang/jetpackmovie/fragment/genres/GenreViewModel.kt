package com.shang.jetpackmovie.fragment.genres

import android.util.Log
import androidx.lifecycle.*
import com.shang.jetpackmovie.api.UiState
import com.shang.jetpackmovie.bean.MovieBean
import com.shang.jetpackmovie.bean.MovieGenreBean
import com.shang.jetpackmovie.bean.MovieListBean

class GenreViewModel(
    private val genre: MovieGenreBean.Genre?,
    private val genreRepository: GenreRepository
) : ViewModel() {

    private var _path = 1
    private val _genreLiveData = MutableLiveData<UiState<List<MovieListBean.Result>>>()


    val genreLiveData = liveData<UiState<List<MovieListBean.Result>>> {
        try {
            val bean = genreRepository.getMovieGenreDetail("${genre?.name}", _path)
            emit(UiState.success(listOf()))
        } catch (e: Exception) {
            emit(UiState.failure(e))
            e.printStackTrace()
        }
    }.switchMap {
        _genreLiveData.value = it
        _genreLiveData
    }
}