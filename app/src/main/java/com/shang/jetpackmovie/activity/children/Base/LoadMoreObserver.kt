package com.shang.jetpackmovie.activity.children.Base

import com.shang.jetpackmovie.bean.IBaseMovie
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

abstract class LoadMoreObserver<I : ILoreMore<D>, D> : Observer<I> {

    abstract fun start(d: Disposable)
    abstract fun success(data: List<D>)
    abstract fun error(e: Throwable)
    abstract fun state(state: LoadMoreState)

    override fun onSubscribe(d: Disposable) {
        state(LoadMoreState.START)
        start(d)
    }

    override fun onNext(t: I) {
        if (t.getIData().isNullOrEmpty() && t.getIPage() == 0) {
            state(LoadMoreState.ERROR)
        } else if (t.getIData().isNotEmpty() && t.getIPage() == 0) {
            state(LoadMoreState.NO_MORE)
            success(t.getIData())
        } else {
            success(t.getIData())
        }
    }

    override fun onError(e: Throwable) {
        error(e)
        state(LoadMoreState.ERROR)
    }

    override fun onComplete() {

    }
}