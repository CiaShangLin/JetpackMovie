package com.shang.jetpackmovie.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.ThemeUtils
import androidx.core.content.ContextCompat
import androidx.core.content.res.use
import com.shang.jetpackmovie.R

/**
 * 電影收藏按鈕
 * 考慮要不要注入MovieFavorDao
 */
class MovieFavoritesImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : androidx.appcompat.widget.AppCompatImageView(context, attrs, defStyleAttr) {

    private var isFavoritesResource: Drawable? = null
    private var noFavoritesResource: Drawable? = null

    init {
        context.obtainStyledAttributes(attrs, R.styleable.MovieFavoritesImageView).use {
            isFavoritesResource = it.getDrawable(
                R.styleable.MovieFavoritesImageView_isFavoritesResource,
            ) ?: ContextCompat.getDrawable(context, R.drawable.icon_favor)

            //目前找不到更好的方法來設置，attr不能直接轉型成Drawable所以在外面一定要設置noFavoritesResource
            noFavoritesResource = it.getDrawable(
                R.styleable.MovieFavoritesImageView_noFavoritesResource,
            )
            if (noFavoritesResource == null) {
                Log.w("DEBUG", "MovieFavoritesImageView 請設置noFavoritesResource")
            }
        }
        setImageDrawable(noFavoritesResource)
    }

    fun setIsFavorites(isFavorites: Boolean) {
        if (isFavorites) {
            setImageDrawable(isFavoritesResource)
        } else {
            setImageDrawable(noFavoritesResource)
        }
    }
}