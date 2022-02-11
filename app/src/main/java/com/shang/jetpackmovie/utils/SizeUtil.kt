package com.shang.jetpackmovie.utils

import android.content.Context

fun Int.dp2px(context: Context): Int = (this * context.resources.displayMetrics.density).toInt()