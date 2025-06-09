package com.shang.jetpackmovie.ui

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.core.content.res.use
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.bean.IBaseMovie
import com.shang.jetpackmovie.epoxy.BaseMovieModel
import java.lang.ref.WeakReference

/**
 * 電影收藏按鈕
 * 考慮要不要注入MovieFavorDao
 */
class MovieFavoritesImageView
    @JvmOverloads
    constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0,
    ) : androidx.appcompat.widget.AppCompatImageView(context, attrs, defStyleAttr) {

        companion object {
            private val tempImageViewSet = mutableSetOf<MovieFavoritesImageView>()
            private val isFavorSet = mutableSetOf<Int>()
        }

        private var isFavoritesResource: Drawable? = null
        private var noFavoritesResource: Drawable? = null
        private var _movieFavorListener: BaseMovieModel.MovieFavorListener? = null
        var mData: IBaseMovie? = null

        init {
            context.obtainStyledAttributes(attrs, R.styleable.MovieFavoritesImageView).use {
                isFavoritesResource = it.getDrawable(
                    R.styleable.MovieFavoritesImageView_isFavoritesResource,
                ) ?: ContextCompat.getDrawable(context, R.drawable.icon_favor)

                // 目前找不到更好的方法來設置，attr不能直接轉型成Drawable所以在外面一定要設置noFavoritesResource
                noFavoritesResource = it.getDrawable(
                    R.styleable.MovieFavoritesImageView_noFavoritesResource,
                )
                if (noFavoritesResource == null) {
                    Log.w("DEBUG", "MovieFavoritesImageView 請設置noFavoritesResource")
                }
            }
            setImageDrawable(noFavoritesResource)
        }

        private fun setIsFavorites(isFavorites: Boolean, id: Int) {
            if (isFavorites) {
                isFavorSet.add(id)
                setImageDrawable(isFavoritesResource)
            } else {
                isFavorSet.remove(id)
                setImageDrawable(noFavoritesResource)
            }
        }

        fun init(baseMovie: IBaseMovie, movieFavorListener: BaseMovieModel.MovieFavorListener?) {
            tempImageViewSet.add(this)
            mData = baseMovie
            _movieFavorListener = movieFavorListener

            var isFavorites = movieFavorListener?.isFavorites(baseMovie.getMovieID()) ?: false
            setIsFavorites(isFavorites, baseMovie.getMovieID())

            setOnClickListener {
                if (isFavorites) {
                    movieFavorListener?.delete(baseMovie)
                } else {
                    movieFavorListener?.insert(baseMovie)
                }
                isFavorites = !isFavorites
                setIsFavorites(isFavorites, baseMovie.getMovieID())
                update()
            }
        }

        override fun onDetachedFromWindow() {
            _movieFavorListener = null
            mData = null
            tempImageViewSet.remove(this)
            super.onDetachedFromWindow()
        }

        private fun update() {
            tempImageViewSet.forEach {
                WeakReference(it).get()?.let {
                    val id = it.mData?.getMovieID() ?: return@let
                    val isFavorites = it._movieFavorListener?.isFavorites(id) ?: false
                    it.setIsFavorites(isFavorites, id)
                }
            }
        }
    }
