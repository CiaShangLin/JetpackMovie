package com.shang.jetpackmovie.globalData

import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
import com.shang.jetpackmovie.utils.SharedPreUtils
import java.util.*

object UserSetting {
    private const val THEME = "THEME"
    private const val LANGUAGE = "LANGUAGE"

    var theme: Int
        get() = SharedPreUtils.getInstance().getValue(THEME, MODE_NIGHT_FOLLOW_SYSTEM)
        set(value) {
            AppCompatDelegate.setDefaultNightMode(value)
            SharedPreUtils.getInstance().setValue(THEME, value)
        }

    var language: String
        get() = SharedPreUtils.getInstance().getValue(LANGUAGE, Locale.getDefault().language)
        set(value) {
            SharedPreUtils.getInstance().setValue(LANGUAGE, value)
        }
}
