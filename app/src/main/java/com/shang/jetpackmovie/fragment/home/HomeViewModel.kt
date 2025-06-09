package com.shang.jetpackmovie.fragment.home

import androidx.lifecycle.*
import com.shang.jetpackmovie.api.UiState

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    val movieGenres = liveData {
        try {
            val movieGenreBean = homeRepository.getMovieGenres()
            emit(UiState.Success(movieGenreBean))
        } catch (e: Exception) {
            emit(UiState.failure(e))
            e.printStackTrace()
        }
    }
}
