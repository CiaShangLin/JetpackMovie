package com.shang.jetpackmovie.epoxy

import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.airbnb.epoxy.EpoxyModelWithView
import com.shang.jetpackmovie.R

@EpoxyModelClass(layout = R.layout.epoxy_error_model)
abstract class ErrorModel: EpoxyModelWithHolder<ErrorViewHolder>() {
    override fun bind(holder: ErrorViewHolder) {
        super.bind(holder)
    }
}