package com.shang.jetpackmovie.activity.detail

import com.airbnb.epoxy.AutoModel
import com.airbnb.epoxy.EpoxyController
import com.shang.jetpackmovie.bean.IBaseMovie

class DetailController: EpoxyController() {

    @AutoModel
    lateinit var contentModel: ContentModel_

    private var mData = mutableListOf<IBaseMovie>()

    fun setData(data:List<IBaseMovie>){
        mData.addAll(data)
        requestModelBuild()
    }

    override fun buildModels() {
        contentModel.addTo(this)



    }
}