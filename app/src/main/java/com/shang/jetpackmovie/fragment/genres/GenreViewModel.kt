package com.shang.jetpackmovie.fragment.genres

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.shang.jetpackmovie.bean.MovieListBean

class GenreViewModel(private val genreRepository: GenreRepository):ViewModel() {
    val livedata = liveData<MovieListBean> {
        val bean = genreRepository.getMovieGenreDetail("12",1)
        Log.d("DEBUG",bean.toString())
    }
}