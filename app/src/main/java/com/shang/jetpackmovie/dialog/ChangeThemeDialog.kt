package com.shang.jetpackmovie.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatDelegate.*
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.globalData.UserSetting

/**
 * MODE_NIGHT_NO：強制不使用夜間主題
 * MODE_NIGHT_YES：強制使用夜間主題
 * MODE_NIGHT_AUTO：根據當前時間自動切換 夜間/非夜間主題
 * MODE_NIGHT_FOLLOW_SYSTEM：預設設定，跟隨系統主題
 * AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
 */
class ChangeThemeDialog(context: Context) : Dialog(context, R.style.FullScreenDialog) {

    private lateinit var radioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_change_theme)

        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        radioGroup = findViewById(R.id.radioGroup)

        when (UserSetting.theme) {
            MODE_NIGHT_FOLLOW_SYSTEM -> {
                radioGroup.check(R.id.rbDefault)
            }
            MODE_NIGHT_NO -> {
                radioGroup.check(R.id.rbLight)
            }
            MODE_NIGHT_YES -> {
                radioGroup.check(R.id.rbDark)
            }
        }

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val theme = when (checkedId) {
                R.id.rbDefault -> MODE_NIGHT_FOLLOW_SYSTEM
                R.id.rbLight -> MODE_NIGHT_NO
                R.id.rbDark -> MODE_NIGHT_YES
                else -> MODE_NIGHT_FOLLOW_SYSTEM
            }
            UserSetting.theme = theme
        }
    }
}