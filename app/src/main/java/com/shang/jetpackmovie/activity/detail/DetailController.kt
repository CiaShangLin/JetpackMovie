package com.shang.jetpackmovie.activity.detail

import android.graphics.Movie
import com.airbnb.epoxy.AutoModel
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyController
import com.shang.jetpackmovie.bean.ActorBean
import com.shang.jetpackmovie.bean.IBaseMovie
import com.shang.jetpackmovie.bean.MovieDetailBean

class DetailController : EpoxyController() {

    @AutoModel
    lateinit var contentModel: ContentModel_

    private var mDetailBean: MovieDetailBean? = null
    private var mActorBean: ActorBean? = null

    fun setDetailBean(data: MovieDetailBean) {
        mDetailBean = data
        requestModelBuild()
    }

    fun setActorBean(data: ActorBean) {
        mActorBean = data
        requestModelBuild()
    }


    override fun buildModels() {
        mDetailBean?.let {
            contentModel
                .data(it)
                .addTo(this)
        }


        val actorModelList = mutableListOf<ActorModel_>()
        mActorBean?.cast?.forEach {
            actorModelList.add(
                ActorModel_()
                    .id(it.id)
                    .data(it)
            )
        }
        CarouselModel_()
            .id("123")
            .models(actorModelList)
            .addTo(this)

    }
}