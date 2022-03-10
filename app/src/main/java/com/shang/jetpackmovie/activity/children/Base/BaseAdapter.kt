package com.shang.jetpackmovie.activity.children.Base

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.shang.jetpackmovie.bean.IBaseMovie

interface IBaseAdapter {
    fun loadMore()
}

abstract class BaseAdapter(
    protected val IBaseAdapter: IBaseAdapter,
    protected val diffUtil: DiffUtil.ItemCallback<IBaseMovie> = MovieDiffUtil
) :
    ListAdapter<IBaseMovie, BaseViewHolder>(diffUtil) {

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }

        if (itemCount != 0 && position == itemCount - 1) {
            IBaseAdapter.loadMore()
        }
    }
}