package com.shang.jetpackmovie.fragment.genres

import com.airbnb.epoxy.AutoModel
import com.airbnb.epoxy.EpoxyController
import com.shang.jetpackmovie.bean.MovieListBean
import com.shang.jetpackmovie.epoxy.BaseMovieModel_
import com.shang.jetpackmovie.epoxy.LoadingModel_

class GenreController: EpoxyController() {

    @AutoModel
    lateinit var loadingModel:LoadingModel_


    private val mData = mutableListOf<MovieListBean.Result>()

    fun setData(results: List<MovieListBean.Result>) {
        mData.addAll(results)
        requestModelBuild()
    }

    override fun buildModels() {
        loadingModel
            .spanSizeOverride { totalSpanCount, position, itemCount ->
                return@spanSizeOverride 2
            }
            .addIf(mData.isEmpty(),this)

        mData.forEachIndexed { index, result ->
           BaseMovieModel_()
               .id(index)
               .data(result)
               .addTo(this)
        }

    }
}