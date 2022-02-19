package com.shang.jetpackmovie.activity.detail

import androidx.lifecycle.ViewModel
import com.shang.jetpackmovie.bean.IBaseMovie
import com.shang.jetpackmovie.epoxy.BaseMovieModel

class DetailViewModel(private val detailRepository: DetailRepository) : ViewModel(),
    BaseMovieModel.MovieFavorListener {
    override fun isFavorites(id: Int): Boolean = detailRepository.isFavorites(id)

    override fun insert(data: IBaseMovie) = detailRepository.insert(data)

    override fun delete(data: IBaseMovie) = detailRepository.delete(data)

}