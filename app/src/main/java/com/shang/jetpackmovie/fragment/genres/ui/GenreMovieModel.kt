package com.shang.jetpackmovie.fragment.genres.ui

import android.content.Context
import com.airbnb.epoxy.EpoxyModelClass
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.activity.detail.DetailActivity
import com.shang.jetpackmovie.epoxy.BaseMovieModel
import com.shang.jetpackmovie.epoxy.BaseMovieViewHolder
import com.shang.jetpackmovie.epoxy.MovieType

@EpoxyModelClass(layout = R.layout.epoxy_base_movie_model, useLayoutOverloads = true)
abstract class GenreMovieModel : BaseMovieModel<GenreMovieModel.GenreMovieViewHolder>() {
    override fun gotoActivity(context: Context) {
        DetailActivity.start(context, data.getMovieID())
    }

    override fun getViewType(): Int = MovieType.GENRE.ordinal

    class GenreMovieViewHolder : BaseMovieViewHolder()
}
