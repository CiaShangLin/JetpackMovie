package com.shang.jetpackmovie.fragment.setting.ui

import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.dialog.ChangeThemeDialog
import com.shang.jetpackmovie.globalData.UserSetting

@EpoxyModelClass(layout = R.layout.epoxy_setting_theme)
abstract class ThemeModel : EpoxyModelWithHolder<ThemeModel.ThemeViewHolder>() {

    override fun bind(holder: ThemeViewHolder) {
        super.bind(holder)
        holder.vContent.setOnClickListener {

//            UserSetting.theme = AppCompatDelegate.MODE_NIGHT_YES
            ChangeThemeDialog(it.context).show()
        }
    }

    class ThemeViewHolder : EpoxyHolder() {
        lateinit var vContent: ConstraintLayout
        override fun bindView(itemView: View) {
            vContent = itemView.findViewById(R.id.vContent)
        }
    }
}