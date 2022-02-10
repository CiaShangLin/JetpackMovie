package com.shang.jetpackmovie.fragment.genres

import android.view.View
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyViewHolder
import com.airbnb.lottie.LottieAnimationView
import com.shang.jetpackmovie.R

class LoadingViewHolder : EpoxyHolder() {
    lateinit var lottieLoading: LottieAnimationView
    override fun bindView(itemView: View) {
        lottieLoading = itemView.findViewById(R.id.lottieLoading)
    }
}