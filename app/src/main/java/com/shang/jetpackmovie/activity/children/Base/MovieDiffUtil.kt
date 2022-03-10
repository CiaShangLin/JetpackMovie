package com.shang.jetpackmovie.activity.children.Base

import androidx.recyclerview.widget.DiffUtil
import com.shang.jetpackmovie.bean.IBaseMovie

object MovieDiffUtil : DiffUtil.ItemCallback<IBaseMovie>() {
    override fun areItemsTheSame(oldItem: IBaseMovie, newItem: IBaseMovie): Boolean {
        return oldItem.getMovieID() == newItem.getMovieID()
    }

    override fun areContentsTheSame(oldItem: IBaseMovie, newItem: IBaseMovie): Boolean {
        return oldItem.getMovieID() == newItem.getMovieID()
    }
}