package com.shang.jetpackmovie.activity.detail

import android.content.Context
import com.airbnb.epoxy.EpoxyModelClass
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.epoxy.BaseMovieModel
import com.shang.jetpackmovie.epoxy.BaseMovieViewHolder

@EpoxyModelClass(layout = R.layout.epoxy_base_movie_model)
abstract class DetailModel:BaseMovieModel<DetailModel.DetailViewHolder>() {

    override fun gotoActivity(context: Context) {

    }

    override fun bind(holder: DetailViewHolder) {
        super.bind(holder)

    }

    class DetailViewHolder: BaseMovieViewHolder() {

    }

}