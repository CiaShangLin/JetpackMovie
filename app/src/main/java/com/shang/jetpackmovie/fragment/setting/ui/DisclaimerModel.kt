package com.shang.jetpackmovie.fragment.setting.ui

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.shang.jetpackmovie.R

@EpoxyModelClass(layout = R.layout.epoxy_setting_disclaimer)
abstract class DisclaimerModel : EpoxyModelWithHolder<DisclaimerModel.DisclaimerViewHolder>(){

    class DisclaimerViewHolder: EpoxyHolder(){
        lateinit var vContent: ConstraintLayout
        override fun bindView(itemView: View) {
            vContent = itemView.findViewById(R.id.vContent)
        }
    }
}