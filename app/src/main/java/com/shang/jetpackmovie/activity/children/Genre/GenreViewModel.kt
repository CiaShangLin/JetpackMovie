package com.shang.jetpackmovie.activity.children.Genre

import android.app.Application
import com.google.gson.Gson
import com.shang.jetpackmovie.activity.children.Base.BaseViewModel
import com.shang.jetpackmovie.activity.children.Base.ILoreMore
import com.shang.jetpackmovie.api.ApiService
import com.shang.jetpackmovie.bean.IBaseMovie
import com.shang.jetpackmovie.bean.MovieListBean
import io.reactivex.rxjava3.core.Observable

class GenreViewModel(application: Application, id: Int) : BaseViewModel(application, id) {
    override fun getApi(): Observable<ILoreMore<IBaseMovie>> {
        return ApiService.movieApi
            .getMovieSimilar(id, mPage)
            .map {
                val json = it.string()
                return@map Gson().fromJson(json, MovieListBean::class.java) as ILoreMore<IBaseMovie>
            }
    }
}