package com.shang.jetpackmovie.activity.children.Base

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.imageview.ShapeableImageView
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.bean.IBaseMovie
import com.shang.jetpackmovie.ui.MovieFavoritesImageView
import com.shang.jetpackmovie.ui.VoteAverageView

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun gotoActivity(context: Context)
    protected var vContent: ConstraintLayout = itemView.findViewById(R.id.vContent)
    protected var ivCover: ShapeableImageView = itemView.findViewById(R.id.ivCover)
    protected var tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
    protected var tvDay: TextView = itemView.findViewById(R.id.tvDay)
    protected var voteAverageView: VoteAverageView = itemView.findViewById(R.id.voteAverageView)
    protected var ivFavor: MovieFavoritesImageView = itemView.findViewById(R.id.ivFavor)
    protected var mData: IBaseMovie? = null

    fun bind(data: IBaseMovie) {
        mData = data
        data.let {
            setSite()
            setCover(it.getPosterPath())
            setTitle(it.getMovieTitle())
            setDay(it.getReleaseDate())
            setVoteAverage(it.getVoteAverage())
            setOnClick()
            setFavorites()
        }
    }


    protected open fun setCover(cover: String) {
        Glide.with(ivCover)
            .load(cover)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(ivCover)
    }

    protected open fun setTitle(title: String) {
        tvTitle.text = title
    }

    protected open fun setDay(day: String) {
        val release_date = tvDay.context.getString(R.string.release_date)
        tvDay.text = "$release_date : $day"
    }

    protected open fun setVoteAverage(voteAverage: Double) {
        voteAverageView.setProgress(voteAverage)
    }

    protected open fun setOnClick() {
        vContent.setOnClickListener {
            gotoActivity(it.context)
        }
    }

    protected open fun setFavorites() {
//        ivFavor.init(data, favorClickListener)
    }

    protected open fun setSite() {
        // change ui constraint
    }
}