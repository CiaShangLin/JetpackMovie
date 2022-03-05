package com.shang.jetpackmovie.activity.detail

import android.view.View
import com.airbnb.epoxy.*
import com.shang.jetpackmovie.R

@EpoxyModelClass(layout = R.layout.epoxy_movie_content)
abstract class ContentModel: EpoxyModelWithHolder<ContentModel.ContentViewHolder>() {

    override fun bind(holder: ContentViewHolder) {
        super.bind(holder)

    }


    class ContentViewHolder: EpoxyHolder() {
        override fun bindView(itemView: View) {

        }
    }
}