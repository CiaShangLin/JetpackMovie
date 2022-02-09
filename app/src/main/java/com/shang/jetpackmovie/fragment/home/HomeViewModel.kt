package com.shang.jetpackmovie.fragment.home

import android.app.Application
import android.util.Log
import androidx.arch.core.util.Function
import androidx.lifecycle.*
import com.shang.jetpackmovie.SharedPreUtils
import com.shang.jetpackmovie.bean.MovieBean
import com.shang.jetpackmovie.api.UiState
import com.shang.jetpackmovie.bean.MovieGenreBean
import com.shang.jetpackmovie.globalData.Configuration
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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