package com.shang.jetpackmovie.dialog

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.activity.main.MainActivity
import com.shang.jetpackmovie.activity.splash.SplashActivity
import com.shang.jetpackmovie.globalData.UserSetting
import com.shang.jetpackmovie.utils.LocaleHelper
import java.util.*

/**
 * 目前做不到立即刷新的效果，只能做到跳回splash或是main去刷新有點麻煩
 * 所以決定照著系統走
 */
class LanguageDialog(context: Context) : Dialog(context, R.style.FullScreenDialog) {

    private lateinit var radioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_language)

        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        radioGroup = findViewById(R.id.radioGroup)

        when (UserSetting.language) {
            Locale.CHINESE.language -> {
                radioGroup.check(R.id.rbChinese)
            }
            Locale.ENGLISH.language -> {
                radioGroup.check(R.id.rbEnglish)
            }
            else -> {
                radioGroup.check(R.id.rbChinese)
            }
        }


        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val locale = when (checkedId) {
                R.id.rbChinese -> Locale.CHINESE
                R.id.rbEnglish -> Locale.ENGLISH
                else -> Locale.CHINESE
            }
            UserSetting.language = locale.language
            dismiss()

            val intent = Intent(context,SplashActivity::class.java)
            context.startActivity(intent)
        }
    }
}