package com.shang.jetpackmovie.fragment.setting.ui

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.dialog.DevelopersDialog

@EpoxyModelClass(layout = R.layout.epoxy_setting_developers)
abstract class DevelopersModel : EpoxyModelWithHolder<DevelopersModel.DevelopersViewHolder>() {

    override fun bind(holder: DevelopersViewHolder) {
        super.bind(holder)
        holder.vContent.setOnClickListener {
            DevelopersDialog(it.context).show()
        }
    }
    class DevelopersViewHolder : EpoxyHolder() {
        lateinit var vContent: ConstraintLayout
        override fun bindView(itemView: View) {
            vContent = itemView.findViewById(R.id.vContent)
        }
    }
}
