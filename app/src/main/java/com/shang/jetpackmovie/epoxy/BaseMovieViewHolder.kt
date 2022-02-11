package com.shang.jetpackmovie.epoxy

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyHolder
import com.google.android.material.imageview.ShapeableImageView
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.ui.VoteAverageView

class BaseMovieViewHolder : EpoxyHolder() {

    lateinit var ivCover: ShapeableImageView
    lateinit var tvTitle: TextView
    lateinit var tvDay: TextView
    lateinit var voteAverageView: VoteAverageView

    override fun bindView(itemView: View) {
        ivCover = itemView.findViewById(R.id.ivCover)
        tvTitle = itemView.findViewById(R.id.tvTitle)
        tvDay = itemView.findViewById(R.id.tvDay)
        voteAverageView = itemView.findViewById(R.id.voteAverageView)
    }
}