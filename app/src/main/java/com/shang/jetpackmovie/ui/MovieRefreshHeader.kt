package com.shang.jetpackmovie.ui

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.lottie.LottieAnimationView
import com.scwang.smart.refresh.layout.api.RefreshHeader
import com.scwang.smart.refresh.layout.api.RefreshKernel
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.constant.RefreshState
import com.scwang.smart.refresh.layout.constant.SpinnerStyle
import com.shang.jetpackmovie.R

class MovieRefreshHeader
    @JvmOverloads
    constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0,
    ) : ConstraintLayout(context, attrs, defStyleAttr), RefreshHeader {

        private val layout: View
        private val refreshLottie: LottieAnimationView

        init {
            layout = LayoutInflater.from(context).inflate(R.layout.movie_refresh_header, this)
            refreshLottie = findViewById(R.id.refreshLottie)
        }

        @SuppressLint("RestrictedApi")
        override fun onStateChanged(
            refreshLayout: RefreshLayout,
            oldState: RefreshState,
            newState: RefreshState,
        ) {
            when (newState) {
                RefreshState.PullDownToRefresh -> {
                    refreshLottie.playAnimation()
                }
                else -> {}
            }
        }

        override fun getView(): View = layout

        override fun getSpinnerStyle(): SpinnerStyle = SpinnerStyle.Translate

        @SuppressLint("RestrictedApi")
        override fun setPrimaryColors(vararg colors: Int) {
        }

        @SuppressLint("RestrictedApi")
        override fun onInitialized(kernel: RefreshKernel, height: Int, maxDragHeight: Int) {
        }

        @SuppressLint("RestrictedApi")
        override fun onMoving(
            isDragging: Boolean,
            percent: Float,
            offset: Int,
            height: Int,
            maxDragHeight: Int,
        ) {
        }

        @SuppressLint("RestrictedApi")
        override fun onReleased(refreshLayout: RefreshLayout, height: Int, maxDragHeight: Int) {
        }

        @SuppressLint("RestrictedApi")
        override fun onStartAnimator(refreshLayout: RefreshLayout, height: Int, maxDragHeight: Int) {
        }

        @SuppressLint("RestrictedApi")
        override fun onFinish(refreshLayout: RefreshLayout, success: Boolean): Int {
            refreshLottie.cancelAnimation()
            return 0
        }

        @SuppressLint("RestrictedApi")
        override fun onHorizontalDrag(percentX: Float, offsetX: Int, offsetMax: Int) {
        }

        override fun isSupportHorizontalDrag(): Boolean = false
    }
