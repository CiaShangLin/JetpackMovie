package com.shang.jetpackmovie.activity.detail.ui

import android.view.View
import com.airbnb.epoxy.*
import com.shang.jetpackmovie.R

@EpoxyModelClass(layout = R.layout.epoxy_actor_title)
abstract class ActorTitleModel : EpoxyModelWithHolder<ActorTitleModel.ActorTitleViewHolder>() {
    override fun bind(holder: ActorTitleViewHolder) {
        super.bind(holder)
    }

    class ActorTitleViewHolder : EpoxyHolder() {
        override fun bindView(itemView: View) {

        }
    }
}