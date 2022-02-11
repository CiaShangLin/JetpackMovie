package com.shang.jetpackmovie.fragment.genres

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyHolder
import com.google.android.material.imageview.ShapeableImageView
import com.shang.jetpackmovie.R

class BaseMovieViewHolder : EpoxyHolder() {

    lateinit var ivCover: ShapeableImageView
    lateinit var tvTitle: TextView
    lateinit var tvDay: TextView

    override fun bindView(itemView: View) {
        ivCover = itemView.findViewById(R.id.ivCover)
        tvTitle = itemView.findViewById(R.id.tvTitle)
        tvDay = itemView.findViewById(R.id.tvDay)
    }
}