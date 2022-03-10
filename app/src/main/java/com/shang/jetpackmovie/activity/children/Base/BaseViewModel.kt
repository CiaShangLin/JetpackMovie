package com.shang.jetpackmovie.activity.children.Base

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shang.jetpackmovie.activity.children.Genre.GenreViewModel
import com.shang.jetpackmovie.bean.IBaseMovie
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


class MovieFactory(val application: Application, val id: Int) : ViewModelProvider.Factory {
    companion object {
        fun create(application: Application, id: Int) = MovieFactory(application, id)
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(GenreViewModel::class.java) -> {
                GenreViewModel(application, id)
            }
            else -> {
                throw IllegalStateException()
            }
        } as T
    }
}

abstract class BaseViewModel<A : ILoreMore<D>, D : IBaseMovie>(
    application: Application,
    val id: Int
) : ViewModel(), IBaseAdapter {

    abstract fun getApi(): Observable<A>

    protected val mMovieLiveData = MutableLiveData<UiState<List<IBaseMovie>>>()
    val movieLiveData: LiveData<UiState<List<IBaseMovie>>> = mMovieLiveData

    protected var mDisposable: Disposable? = null
    protected var mPage = 1
    protected var mDataList = mutableListOf<IBaseMovie>()

    init {
        getMovie()
    }

    protected fun getMovie() {
        Log.d("DEBUG","${mDisposable==null} ${mDisposable?.isDisposed}")
        if (mDisposable != null && mDisposable?.isDisposed == false) {
            return
        }
        getApi()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : LoadMoreObserver<A, D>() {
                override fun start(d: Disposable) {
                    mDisposable = d
                }

                override fun error(e: Throwable) {
                    mMovieLiveData.value = UiState.failure()
                    mDisposable?.dispose()
                    mDisposable = null
                }

                override fun state(state: LoadMoreState) {

                }

                override fun success(data: List<D>) {
                    mDataList.addAll(data)
                    mPage++
                    mMovieLiveData.value = UiState.success(mDataList.map { it.clone() })
                    mDisposable?.dispose()
                    mDisposable = null
                }
            })
    }

    override fun loadMore() {
        Log.d("DEBUG", "loadMore")
        getMovie()
    }
}