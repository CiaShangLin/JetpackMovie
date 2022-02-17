package com.shang.jetpackmovie.fragment.favor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.shang.jetpackmovie.bean.IBaseMovie
import com.shang.jetpackmovie.epoxy.BaseMovieModel
import com.shang.jetpackmovie.room.entity.MovieFavorEntity

class FavorViewModel(private val favorRepository: FavorRepository) : ViewModel(),
    BaseMovieModel.MovieFavorListener {

    fun getAll() = favorRepository.getAll()

    override fun isFavorites(id: Int): Boolean = favorRepository.isFavorites(id)

    override fun insert(data: IBaseMovie) = favorRepository.insert(data)

    override fun delete(data: IBaseMovie) = favorRepository.delete(data)

}