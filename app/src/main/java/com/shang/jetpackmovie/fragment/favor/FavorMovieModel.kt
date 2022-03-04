package com.shang.jetpackmovie.fragment.favor

import android.content.Context
import android.util.Log
import com.airbnb.epoxy.EpoxyModelClass
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.activity.detail.DetailActivity
import com.shang.jetpackmovie.bean.BaseMovieBean
import com.shang.jetpackmovie.epoxy.BaseMovieModel
import com.shang.jetpackmovie.epoxy.MovieType
import com.shang.jetpackmovie.fragment.genres.ui.GenreMovieViewHolder

@EpoxyModelClass(layout = R.layout.epoxy_base_movie_model,useLayoutOverloads = true)
abstract class FavorMovieModel: BaseMovieModel<FavorMovieViewHolder>() {

    override fun gotoActivity(context: Context) {
        DetailActivity.start(context,data.getMovieID())
    }

    override fun getViewType(): Int  = MovieType.FAVOR.ordinal
}