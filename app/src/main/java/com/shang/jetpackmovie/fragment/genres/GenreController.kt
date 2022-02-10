package com.shang.jetpackmovie.fragment.genres

import com.airbnb.epoxy.AutoModel
import com.airbnb.epoxy.EpoxyController
import com.shang.jetpackmovie.bean.MovieGenreBean
import com.shang.jetpackmovie.bean.MovieListBean

class GenreController: EpoxyController() {

    @AutoModel
    lateinit var loadingModel:LoadingModel_

    private val mData = mutableListOf<MovieListBean.Result>()

    override fun buildModels() {
        loadingModel
            .spanSizeOverride { totalSpanCount, position, itemCount ->
                return@spanSizeOverride 2
            }
            .addIf(mData.isEmpty(),this)
    }
}