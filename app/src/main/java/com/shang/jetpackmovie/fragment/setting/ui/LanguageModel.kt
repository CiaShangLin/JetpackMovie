package com.shang.jetpackmovie.fragment.setting.ui

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.dialog.LanguageDialog

@EpoxyModelClass(layout = R.layout.epoxy_setting_language)
abstract class LanguageModel:EpoxyModelWithHolder<LanguageModel.LanguageViewHolder>() {

    override fun bind(holder: LanguageViewHolder) {
        super.bind(holder)
        holder.vContent.setOnClickListener {
            LanguageDialog(it.context).show()
        }
    }

    class LanguageViewHolder : EpoxyHolder() {
        lateinit var vContent: ConstraintLayout
        override fun bindView(itemView: View) {
            vContent = itemView.findViewById(R.id.vContent)
        }
    }
}