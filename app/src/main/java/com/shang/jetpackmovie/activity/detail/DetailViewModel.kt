package com.shang.jetpackmovie.activity.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shang.jetpackmovie.bean.IBaseMovie
import com.shang.jetpackmovie.epoxy.BaseMovieModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

class DetailViewModel(private val id: Int, private val detailRepository: DetailRepository) :
    ViewModel(),
    BaseMovieModel.MovieFavorListener {


    fun getMovieDetail(): Job {
        return viewModelScope.launch {
            val movieDetail = detailRepository.getMovieDetail(id)
            Log.d("DEBUG", "movieDetail.toString()")
        }
    }

    fun getMovieActor(): Job {
        return viewModelScope.launch {
            val movieActor = detailRepository.getMovieActor(id)
            Log.d("DEBUG", "movieActor.toString()")
        }
    }

    fun getMovieRecommendations(): Job {
        return viewModelScope.launch {
            val movieRecommendations=detailRepository.getMovieRecommendations(id)
            Log.d("DEBUG","movieRecommendations.toString()")
        }
    }

    override fun isFavorites(id: Int): Boolean = detailRepository.isFavorites(id)

    override fun insert(data: IBaseMovie) = detailRepository.insert(data)

    override fun delete(data: IBaseMovie) = detailRepository.delete(data)

}