package com.shang.jetpackmovie.activity.detail.ui

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.bean.MovieDetailBean

@EpoxyModelClass(layout = R.layout.epoxy_movie_content)
abstract class ContentModel : EpoxyModelWithHolder<ContentModel.ContentViewHolder>() {

    @EpoxyAttribute
    lateinit var data: MovieDetailBean

    override fun bind(holder: ContentViewHolder) {
        super.bind(holder)
        holder.tvContent.text = data.overview
    }

    class ContentViewHolder : EpoxyHolder() {
        lateinit var tvContent: TextView
        lateinit var tvSummary: TextView

        override fun bindView(itemView: View) {
            tvContent = itemView.findViewById(R.id.tvContent)
            tvSummary = itemView.findViewById(R.id.tvSummary)
        }
    }
}
