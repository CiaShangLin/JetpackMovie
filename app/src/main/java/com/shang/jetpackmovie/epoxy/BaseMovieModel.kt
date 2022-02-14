package com.shang.jetpackmovie.epoxy

import android.content.Context
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.imageview.ShapeableImageView
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.ui.VoteAverageView
import com.shang.jetpackmovie.bean.MovieListBean

/**
 * @EpoxyModelClass當有這個註解的時候不能使用泛型,因為他會產出_的class他是new不出泛型的class
 * 可以泛型ViewModel但是不能泛型其他的，目前還找不到原因，可能是要繼承其他的class
 * BaseMovieModel設定為給子類繼承可以不用寫@EpoxyModelClass，但是子類一定要寫
 */
//@EpoxyModelClass(layout = R.layout.epoxy_base_movie_model)
abstract class BaseMovieModel<VH : BaseMovieViewHolder> :
    EpoxyModelWithHolder<VH>() {

    interface MovieFavorListener {
        fun isFavorites(id: Int): Boolean
        fun insert(data: MovieListBean.Result)
        fun delete(data: MovieListBean.Result)
    }

    abstract fun gotoActivity(context: Context)

    @EpoxyAttribute
    lateinit var data: MovieListBean.Result

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var itemClickListener: ((context: Context) -> Unit)? = null

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var favorClickListener: MovieFavorListener? = null

    override fun bind(holder: VH) {
        super.bind(holder)
        data.let {
            setCover(holder.ivCover, it.poster_path)
            setTitle(holder.tvTitle, it.title)
            setDay(holder.tvDay, it.release_date)
            setVoteAverage(holder.voteAverageView, it.vote_average)
            setOnClick(holder.vContent)
            setFavorites(holder.ivFavor)
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

    protected open fun setVoteAverage(voteAverageView: VoteAverageView, voteAverage: Double) {
        voteAverageView.setProgress(voteAverage)
    }

    protected open fun setOnClick(vContent: ConstraintLayout) {
        vContent.setOnClickListener {
            gotoActivity(it.context)
        }
    }

    protected open fun setFavorites(ivFavor: ImageView) {
        var isFavorites = favorClickListener?.isFavorites(data.id) ?: false
        if (isFavorites) {
            ivFavor.setImageResource(R.drawable.icon_favor)
        } else {
            ivFavor.setImageResource(R.drawable.icon_not_favor)
        }
        ivFavor.setOnClickListener {
            if (isFavorites) {
                ivFavor.setImageResource(R.drawable.icon_not_favor)
                favorClickListener?.delete(data)
            } else {
                ivFavor.setImageResource(R.drawable.icon_favor)
                favorClickListener?.insert(data)
            }
            isFavorites = !isFavorites
        }
    }

}