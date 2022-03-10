package com.shang.jetpackmovie.activity.children.Genre

import android.view.LayoutInflater
import android.view.ViewGroup
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.activity.children.Base.BaseAdapter
import com.shang.jetpackmovie.activity.children.Base.BaseViewHolder
import com.shang.jetpackmovie.activity.children.Base.IBaseAdapter

class GenreAdapter(loadMore:IBaseAdapter): BaseAdapter(loadMore) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.epoxy_base_movie_model,parent,false)
        return GenreViewHolder(view)
    }
}