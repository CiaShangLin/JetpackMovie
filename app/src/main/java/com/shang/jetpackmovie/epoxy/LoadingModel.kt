package com.shang.jetpackmovie.epoxy

import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.shang.jetpackmovie.R

@EpoxyModelClass(layout = R.layout.epoxy_loading_model)
abstract class LoadingModel : EpoxyModelWithHolder<LoadingViewHolder>() {
    override fun bind(holder: LoadingViewHolder) {
        super.bind(holder)
        holder.lottieLoading.playAnimation()
    }

    override fun unbind(holder: LoadingViewHolder) {
        holder.lottieLoading.cancelAnimation()
        super.unbind(holder)
    }
}
