package com.shang.jetpackmovie.fragment.favor

import android.content.Context
import com.airbnb.epoxy.EpoxyModelClass
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.epoxy.BaseMovieModel
import com.shang.jetpackmovie.epoxy.BaseMovieViewHolder
import com.shang.jetpackmovie.room.entity.MovieFavorEntity

@EpoxyModelClass(layout = R.layout.epoxy_base_movie_model)
abstract class FavorMovieModel: BaseMovieModel<FavorMovieViewHolder>() {
    override fun gotoActivity(context: Context) {

    }
}