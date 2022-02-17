package com.shang.jetpackmovie.fragment.genres.ui

import android.content.Context
import android.util.Log
import com.airbnb.epoxy.EpoxyModelClass
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.epoxy.BaseMovieModel

@EpoxyModelClass(layout = R.layout.epoxy_base_movie_model)
abstract class GenreMovieModel : BaseMovieModel<GenreMovieViewHolder>() {

    override fun gotoActivity(context: Context) {

    }
}