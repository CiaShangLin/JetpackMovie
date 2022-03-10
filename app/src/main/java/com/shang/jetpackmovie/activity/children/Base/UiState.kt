package com.shang.jetpackmovie.activity.children.Base

sealed class UiState<out T> {
    class Success<T>(val data: T) : UiState<T>()
    object Failure : UiState<Nothing>()
    object Loading : UiState<Nothing>()
    object NoMore : UiState<Nothing>()
    companion object {
        fun <T> success(data: T) = Success<T>(data)
        fun failure() = Failure
        fun loading() = Loading
        fun noMore() = NoMore
    }
}