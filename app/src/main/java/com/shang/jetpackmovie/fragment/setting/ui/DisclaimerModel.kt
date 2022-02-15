package com.shang.jetpackmovie.fragment.setting.ui

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.dialog.DisclaimerDialog

@EpoxyModelClass(layout = R.layout.epoxy_setting_disclaimer)
abstract class DisclaimerModel : EpoxyModelWithHolder<DisclaimerModel.DisclaimerViewHolder>() {

    override fun bind(holder: DisclaimerViewHolder) {
        super.bind(holder)
        holder.vContent.setOnClickListener {
            DisclaimerDialog(it.context).show()
        }
    }

    class DisclaimerViewHolder : EpoxyHolder() {
        lateinit var vContent: ConstraintLayout
        override fun bindView(itemView: View) {
            vContent = itemView.findViewById(R.id.vContent)
        }
    }
}