package com.shang.jetpackmovie.fragment.favor

import com.airbnb.epoxy.EpoxyController
import com.shang.jetpackmovie.epoxy.BaseMovieModel
import com.shang.jetpackmovie.room.entity.MovieFavorEntity

class FavorMovieController(private val movieFavorListener: BaseMovieModel.MovieFavorListener): EpoxyController() {

    private val mData  = mutableListOf<MovieFavorEntity>()

    fun setData(data:List<MovieFavorEntity>){
        mData.clear()
        mData.addAll(data)
        requestModelBuild()
    }

    override fun buildModels() {
        mData.forEachIndexed { index, movieFavorEntity ->
            FavorMovieModel_()
                .id(movieFavorEntity.id)
                .data(movieFavorEntity)
                .favorClickListener(movieFavorListener)
                .addTo(this)
        }
    }
}