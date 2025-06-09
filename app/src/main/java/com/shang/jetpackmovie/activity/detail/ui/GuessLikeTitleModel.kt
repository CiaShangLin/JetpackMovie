package com.shang.jetpackmovie.activity.detail.ui

import android.view.View
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.shang.jetpackmovie.R

@EpoxyModelClass(layout = R.layout.epoxy_guess_like_title)
abstract class GuessLikeTitleModel : EpoxyModelWithHolder<GuessLikeTitleModel.GuessLikeTitleViewHolder>() {

    override fun bind(holder: GuessLikeTitleViewHolder) {
        super.bind(holder)
    }

    class GuessLikeTitleViewHolder : EpoxyHolder() {
        override fun bindView(itemView: View) {
        }
    }
}
