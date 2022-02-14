package com.shang.jetpackmovie.epoxy

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.EpoxyHolder
import com.google.android.material.imageview.ShapeableImageView
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.ui.MovieFavoritesImageView
import com.shang.jetpackmovie.ui.VoteAverageView

open class BaseMovieViewHolder : EpoxyHolder() {

    lateinit var vContent: ConstraintLayout
    lateinit var ivCover: ShapeableImageView
    lateinit var tvTitle: TextView
    lateinit var tvDay: TextView
    lateinit var voteAverageView: VoteAverageView
    lateinit var ivFavor: MovieFavoritesImageView

    override fun bindView(itemView: View) {
        vContent = itemView.findViewById(R.id.vContent)
        ivCover = itemView.findViewById(R.id.ivCover)
        tvTitle = itemView.findViewById(R.id.tvTitle)
        tvDay = itemView.findViewById(R.id.tvDay)
        voteAverageView = itemView.findViewById(R.id.voteAverageView)
        ivFavor = itemView.findViewById(R.id.ivFavor)
    }
}