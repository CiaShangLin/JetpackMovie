package com.shang.jetpackmovie.epoxy

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyViewHolder
import com.shang.jetpackmovie.R

class ErrorViewHolder : EpoxyHolder() {

    lateinit var ivError: ImageView
    lateinit var tvError: TextView

    override fun bindView(itemView: View) {
        ivError = itemView.findViewById(R.id.ivError)
        tvError = itemView.findViewById(R.id.tvError)
    }

}