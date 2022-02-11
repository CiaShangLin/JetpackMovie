package com.shang.jetpackmovie

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.shang.jetpackmovie.utils.dp2px

class VoteAverageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var mProgress: Double = 8.0

    private val centerX by lazy { width / 2.0f }
    private val centerY by lazy { height / 2.0f }

    private val mProgressWidth by lazy { 4.dp2px(context).toFloat() }
    private val mProgressPadding by lazy { mProgressWidth / 2 }

    private val mProgressPaint by lazy {
        Paint().apply {
            color = ContextCompat.getColor(context, R.color.green_01b468)
            strokeWidth = mProgressWidth
            style = Paint.Style.STROKE
            strokeCap = Paint.Cap.ROUND
            isAntiAlias = true
        }
    }

    private val mProgressBackgroundPaint by lazy {
        Paint().apply {
            color = ContextCompat.getColor(context, R.color.black_3c3c3c)
            strokeWidth = mProgressWidth
            style = Paint.Style.STROKE
            isAntiAlias = true
        }
    }

    private val mFillPint by lazy {
        Paint().apply {
            color = ContextCompat.getColor(context, R.color.black_272727)
            style = Paint.Style.FILL
            isAntiAlias = true
        }
    }

    private val mTextPaint by lazy {
        Paint().apply {
            color = ContextCompat.getColor(context, R.color.white)
            style = Paint.Style.FILL
            textSize = 12.dp2px(context).toFloat()
            textAlign = Paint.Align.CENTER
            isAntiAlias = true
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
                getPercentAngle(),
                false,
                mProgressPaint
            )
            it.drawText("${(mProgress * 10).toInt()}%", centerX, mTextCenterY, mTextPaint)
        }
    }

    fun setProgress(progress: Double) {
        mProgress = progress
        invalidate()
    }

    //progress傳進來的時候會是8.4不會是84這樣
    private fun getPercentAngle(): Float {
        return (mProgress * 10 / 100 * 360).toFloat()
    }
}