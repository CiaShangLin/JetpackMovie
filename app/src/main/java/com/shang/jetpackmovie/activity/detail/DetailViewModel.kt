package com.shang.jetpackmovie.activity.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.shang.jetpackmovie.bean.IBaseMovie
import com.shang.jetpackmovie.epoxy.BaseMovieModel

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

        override fun isFavorites(id: Int): Boolean = detailRepository.isFavorites(id)

        override fun insert(data: IBaseMovie) = detailRepository.insert(data)

        override fun delete(data: IBaseMovie) = detailRepository.delete(data)
    }
