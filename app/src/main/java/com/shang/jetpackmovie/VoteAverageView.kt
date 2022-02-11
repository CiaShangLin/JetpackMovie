package com.shang.jetpackmovie

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat

class VoteAverageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var progressText = 0

    private val centerX by lazy { width / 2.0f }
    private val centerY by lazy { height / 2.0f }

    private val mProgressWidth = 24f
    private val mProgressPadding = mProgressWidth / 2

    private val mProgressPaint by lazy {
        Paint().apply {
            color = ContextCompat.getColor(context, R.color.green_01b468)
            strokeWidth = mProgressWidth
            style = Paint.Style.STROKE
            //開頭和結尾的圓角
        }
    }

    private val mProgressBackgroundPaint by lazy {
        Paint().apply {
            color = ContextCompat.getColor(context, R.color.black_3c3c3c)
            strokeWidth = mProgressWidth
            style = Paint.Style.STROKE
        }
    }

    private val mFillPint by lazy {
        Paint().apply {
            color = ContextCompat.getColor(context, R.color.black_272727)
            style = Paint.Style.FILL
        }
    }

    private val mTextPaint by lazy {
        Paint().apply {
            color = ContextCompat.getColor(context, R.color.white)
            style = Paint.Style.FILL
            textSize = 120f
            textAlign = Paint.Align.CENTER
        }
    }

    private val mTextCenterY by lazy {
        val fontMetrics = mTextPaint.fontMetrics
        val distance = (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom
        centerY + distance
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        canvas?.let {
            it.drawCircle(centerX, centerY, centerX, mFillPint)
            it.drawArc(
                mProgressPadding,
                centerY - centerX + mProgressPadding,
                width.toFloat() - mProgressPadding,
                centerY + centerX - mProgressPadding,
                -90f,
                360f,
                false,
                mProgressBackgroundPaint
            )
            it.drawArc(
                mProgressPadding,
                centerY - centerX + mProgressPadding,
                width.toFloat() - mProgressPadding,
                centerY + centerX - mProgressPadding,
                -90f,
                36f,
                false,
                mProgressPaint
            )
            it.drawText("10%", centerX, mTextCenterY, mTextPaint)
        }
    }

    fun setText(){

    }

    fun setProgress(){

    }
}