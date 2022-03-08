package com.shang.jetpackmovie.activity.detail.ui

import android.content.Context
import com.airbnb.epoxy.EpoxyModelClass
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.epoxy.BaseMovieModel
import com.shang.jetpackmovie.epoxy.BaseMovieViewHolder

@EpoxyModelClass(layout = R.layout.epoxy_base_movie_model)
abstract class GuessLikeModel : BaseMovieModel<GuessLikeModel.GuessLikeViewHolder>() {

    override fun gotoActivity(context: Context) {

    }

    override fun setSite(holder: GuessLikeViewHolder) {
        holder.vContent.layoutParams.width =
            (holder.vContent.context.resources.displayMetrics.widthPixels * 0.4).toInt()
    }

    override fun bind(holder: GuessLikeViewHolder) {
        super.bind(holder)

    }

    class GuessLikeViewHolder : BaseMovieViewHolder() {

    }

}