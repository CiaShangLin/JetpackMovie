package com.shang.jetpackmovie.activity.detail.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.bean.Cast

@EpoxyModelClass(layout = R.layout.epoxy_actor)
abstract class ActorModel : EpoxyModelWithHolder<ActorModel.ActorViewHolder>() {

    @EpoxyAttribute
    lateinit var data: Cast

    override fun bind(holder: ActorViewHolder) {
        super.bind(holder)

        holder.setSite()
        Glide.with(holder.ivCover)
            .load(data.profile_path)
            .into(holder.ivCover)

        holder.tvName.text = data.name
        holder.tvCharacter.text = data.character
    }

    class ActorViewHolder : EpoxyHolder() {

        lateinit var vContent: ConstraintLayout
        lateinit var ivCover: ImageView
        lateinit var tvName: TextView
        lateinit var tvCharacter: TextView

        override fun bindView(itemView: View) {
            vContent = itemView.findViewById(R.id.vContent)
            ivCover = itemView.findViewById(R.id.ivCover)
            tvName = itemView.findViewById(R.id.tvName)
            tvCharacter = itemView.findViewById(R.id.tvCharacter)
        }

        fun setSite() {
            vContent.layoutParams.width =
                (vContent.context.resources.displayMetrics.widthPixels * 0.3).toInt()
        }
    }
}
