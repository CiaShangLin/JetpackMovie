package com.shang.jetpackmovie.fragment.setting

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.utils.dp2px

class SettingDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private val linePaint by lazy {
        Paint().apply {
            color = ContextCompat.getColor(context, R.color.black_3c3c3c)
            style = Paint.Style.STROKE
        }
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildLayoutPosition(view)
        val itemCount = parent.adapter?.itemCount ?: 0

        if (position != itemCount - 1) {
            outRect.bottom = 1.dp2px(parent.context)
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        val itemCount = parent.adapter?.itemCount ?: 0
        for (i in 0 until itemCount) {
            val view = parent.getChildAt(i)
            if (view != null) {
                val left = view.left.toFloat()
                val right = view.right.toFloat()
                val bottom = view.bottom.toFloat()
                val lineHeight = 1.dp2px(parent.context)
                c.drawLine(left, bottom, right, bottom + lineHeight, linePaint)
            }
        }
    }
}
