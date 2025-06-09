package com.shang.jetpackmovie.activity.detail

import com.airbnb.epoxy.AutoModel
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyController
import com.shang.jetpackmovie.activity.detail.ui.ActorModel_
import com.shang.jetpackmovie.activity.detail.ui.ActorTitleModel_
import com.shang.jetpackmovie.activity.detail.ui.ContentModel_
import com.shang.jetpackmovie.activity.detail.ui.GuessLikeModel_
import com.shang.jetpackmovie.activity.detail.ui.GuessLikeTitleModel_
import com.shang.jetpackmovie.bean.ActorBean
import com.shang.jetpackmovie.bean.MovieDetailBean
import com.shang.jetpackmovie.bean.MovieListBean
import com.shang.jetpackmovie.epoxy.BaseMovieModel
import com.shang.jetpackmovie.epoxy.NoSnapCarouselModel_

class DetailController(private val movieFavorListener: BaseMovieModel.MovieFavorListener) : EpoxyController() {

    @AutoModel
    lateinit var contentModel: ContentModel_

    @AutoModel
    lateinit var actorTitleModel: ActorTitleModel_

    @AutoModel
    lateinit var guessLikTitleModel: GuessLikeTitleModel_

    private var mDetailBean: MovieDetailBean? = null
    private var mActorBean: ActorBean? = null
    private var mGuessLike: MovieListBean? = null

    fun setDetailBean(data: MovieDetailBean) {
        mDetailBean = data
        requestModelBuild()
    }

    fun setActorBean(data: ActorBean) {
        mActorBean = data
        requestModelBuild()
    }

    fun setGuessLike(guessLike: MovieListBean) {
        mGuessLike = guessLike
        requestModelBuild()
    }

    override fun buildModels() {
        mDetailBean?.let {
            contentModel
                .data(it)
                .addTo(this)
        }

        actorTitleModel
            .addTo(this)

        val actorModelList = mutableListOf<ActorModel_>()
        mActorBean?.cast?.forEach {
            actorModelList.add(
                ActorModel_()
                    .id(it.id)
                    .data(it),
            )
        }
        CarouselModel_()
            .id("actor")
            .models(actorModelList)
            .addTo(this)

        guessLikTitleModel.addTo(this)

        val guessLikeList = mutableListOf<GuessLikeModel_>()
        mGuessLike?.results?.forEach {
            val model = GuessLikeModel_()
                .id(it.id)
                .data(it)
                .favorClickListener(movieFavorListener)
            guessLikeList.add(model)
        }

        NoSnapCarouselModel_()
            .id("guessLike")
            .models(guessLikeList)
            .hasFixedSize(true)
            .addTo(this)
    }
}
