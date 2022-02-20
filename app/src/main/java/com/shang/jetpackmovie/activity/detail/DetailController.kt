package com.shang.jetpackmovie.activity.detail

import com.airbnb.epoxy.EpoxyController
import com.shang.jetpackmovie.bean.IBaseMovie

class DetailController: EpoxyController() {

    private var mData = mutableListOf<IBaseMovie>()

    fun setData(data:List<IBaseMovie>){
        mData.addAll(data)
        requestModelBuild()
    }

    override fun buildModels() {
        mData.forEachIndexed { index, iBaseMovie ->
            DetailModel_()
                .id(index)
                .data(iBaseMovie)
                .addTo(this)
        }


    }
}