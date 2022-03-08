package com.shang.jetpackmovie.utils

import android.content.Context
import com.shang.jetpackmovie.core.JetpackMovieApplication

fun Int.dp2px(context: Context): Int = (this * context.resources.displayMetrics.density).toInt()

fun Int.dp(): Int = (this * JetpackMovieApplication.context!!.resources.displayMetrics.density).toInt()