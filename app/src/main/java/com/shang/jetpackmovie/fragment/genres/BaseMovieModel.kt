package com.shang.jetpackmovie.fragment.genres

import com.airbnb.epoxy.EpoxyModelWithHolder


abstract class BaseMovieModel: EpoxyModelWithHolder<BaseMovieViewHolder>() {
    override fun bind(holder: BaseMovieViewHolder) {
        super.bind(holder)

    }
}