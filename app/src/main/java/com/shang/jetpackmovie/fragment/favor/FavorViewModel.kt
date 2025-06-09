package com.shang.jetpackmovie.fragment.favor

import androidx.lifecycle.ViewModel
import com.shang.jetpackmovie.bean.IBaseMovie
import com.shang.jetpackmovie.epoxy.BaseMovieModel

class FavorViewModel(private val favorRepository: FavorRepository) :
    ViewModel(),
    BaseMovieModel.MovieFavorListener {

        fun getAll() = favorRepository.getAll()

        override fun isFavorites(id: Int): Boolean = favorRepository.isFavorites(id)

        override fun insert(data: IBaseMovie) = favorRepository.insert(data)

        override fun delete(data: IBaseMovie) = favorRepository.delete(data)
    }
