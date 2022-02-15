package com.shang.jetpackmovie.fragment.favor

import com.airbnb.epoxy.EpoxyController
import com.shang.jetpackmovie.room.entity.MovieFavorEntity

class FavorMovieController: EpoxyController() {

    private val mData  = mutableListOf<MovieFavorEntity>()

    fun setData(data:List<MovieFavorEntity>){
        mData.clear()
        mData.addAll(data)
        requestModelBuild()
    }

    override fun buildModels() {

        mData.forEachIndexed { index, movieFavorEntity ->
            FavorMovieModel_()
                .id(index)
                .data(movieFavorEntity)
                .favorClickListener(null)
                .addTo(this)
        }
    }
}