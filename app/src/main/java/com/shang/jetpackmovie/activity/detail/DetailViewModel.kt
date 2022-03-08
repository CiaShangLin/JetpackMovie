package com.shang.jetpackmovie.activity.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.shang.jetpackmovie.bean.IBaseMovie
import com.shang.jetpackmovie.bean.MovieDetailBean
import com.shang.jetpackmovie.epoxy.BaseMovieModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class DetailViewModel(private val id: Int, private val detailRepository: DetailRepository) :
    ViewModel(),
    BaseMovieModel.MovieFavorListener {

    val detailLiveData = liveData {
        val movieDetail = detailRepository.getMovieDetail(id)
        emit(movieDetail)
    }

    val actorLiveData = liveData {
        val movieActor = detailRepository.getMovieActor(id)
        emit(movieActor)
    }

    val guessLikeLiveData = liveData {
        val movieRecommendations = detailRepository.getMovieRecommendations(id)
        emit(movieRecommendations)
    }

//    init {
//        viewModelScope.launch {
//            flow<Int> {
//                val movieDetail = async {
//
//                    detailRepository.getMovieDetail(id)
//                }
//
//                val movieActor = async {  detailRepository.getMovieActor(id)}
//
//                emit(0)
//            }.collect {
//                Log.d("DEBUG","$it")
//            }
//        }
//    }


    override fun isFavorites(id: Int): Boolean = detailRepository.isFavorites(id)

    override fun insert(data: IBaseMovie) = detailRepository.insert(data)

    override fun delete(data: IBaseMovie) = detailRepository.delete(data)

}