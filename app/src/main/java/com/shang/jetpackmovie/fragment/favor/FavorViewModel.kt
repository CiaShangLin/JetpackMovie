package com.shang.jetpackmovie.fragment.favor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.shang.jetpackmovie.room.entity.MovieFavorEntity

class FavorViewModel(private val favorRepository: FavorRepository) : ViewModel() {

    fun getAll() = favorRepository.getAll()

}