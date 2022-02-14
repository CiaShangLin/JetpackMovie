package com.shang.jetpackmovie.fragment.genres

import com.airbnb.epoxy.AutoModel
import com.airbnb.epoxy.EpoxyController
import com.shang.jetpackmovie.bean.MovieListBean
import com.shang.jetpackmovie.epoxy.BaseMovieModel

import com.shang.jetpackmovie.epoxy.ErrorModel_
import com.shang.jetpackmovie.epoxy.LoadingModel_
import com.shang.jetpackmovie.fragment.genres.ui.GenreMovieModel_

class GenreController(private val movieFavorListener: BaseMovieModel.MovieFavorListener) :
    EpoxyController() {

    @AutoModel
    lateinit var loadingModel: LoadingModel_

    @AutoModel
    lateinit var errorModel: ErrorModel_

    private var mError = false

    private val mData = mutableListOf<MovieListBean.Result>()

    fun setData(results: List<MovieListBean.Result>) {
        mData.addAll(results)
        requestModelBuild()
    }

    fun refresh() {
        mData.clear()
        mError = false
        requestModelBuild()
    }

    fun setError() {
        mError = true
        requestModelBuild()
    }

    override fun buildModels() {
        loadingModel
            .spanSizeOverride { totalSpanCount, position, itemCount ->
                return@spanSizeOverride 2
            }
            .addIf(mData.isEmpty() && !mError, this)

        errorModel
            .spanSizeOverride { totalSpanCount, position, itemCount ->
                return@spanSizeOverride 2
            }
            .addIf(mData.isEmpty() && mError, this)


        mData.forEachIndexed { index, result ->
            GenreMovieModel_()
                .id(index)
                .data(result)
                .favorClickListener(movieFavorListener)
                .addTo(this)
        }
    }
}