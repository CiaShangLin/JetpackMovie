package com.shang.jetpackmovie.fragment.genres

import android.util.Log
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.imageview.ShapeableImageView
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.bean.MovieListBean

@EpoxyModelClass(layout = R.layout.epoxy_base_movie_model)
abstract class BaseMovieModel : EpoxyModelWithHolder<BaseMovieViewHolder>() {

    @EpoxyAttribute
    var data: MovieListBean.Result? = null

    override fun bind(holder: BaseMovieViewHolder) {
        super.bind(holder)
        data?.let {
            setCover(holder.ivCover, it.poster_path)
            setTitle(holder.tvTitle, it.title)
            setDay(holder.tvDay, it.release_date)
            Log.d("DEBUG","${data?.vote_average}")
        }
    }

    protected open fun setCover(ivCover: ShapeableImageView, cover: String) {
        Glide.with(ivCover)
            .load(cover)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(ivCover)
    }

    protected open fun setTitle(tvTitle: TextView, title: String) {
        tvTitle.text = title
    }

    protected open fun setDay(tvDay: TextView, day: String) {
        val release_date = tvDay.context.getString(R.string.release_date)
        tvDay.text = "$release_date : $day"
    }
}