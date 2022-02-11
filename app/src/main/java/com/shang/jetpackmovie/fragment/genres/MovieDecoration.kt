package com.shang.jetpackmovie.fragment.genres

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.shang.jetpackmovie.utils.dp2px

class MovieDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildLayoutPosition(view)
        if (position == 0 || position == 1) {
            outRect.bottom = 8.dp2px(parent.context)
            outRect.top = 16.dp2px(parent.context)
        } else {
            outRect.bottom = 8.dp2px(parent.context)
        }

        if (position % 2 == 0) {
            outRect.left=8.dp2px(parent.context)
            outRect.right=4.dp2px(parent.context)
        } else {
            outRect.left=4.dp2px(parent.context)
            outRect.right=8.dp2px(parent.context)
        }
    }
}