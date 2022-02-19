package com.shang.jetpackmovie.activity.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.bean.BaseMovieBean
import com.shang.jetpackmovie.bean.IBaseMovie
import com.shang.jetpackmovie.bean.MovieListBean
import com.shang.jetpackmovie.fragment.favor.FavorViewModel
import com.shang.jetpackmovie.ui.MovieFavoritesImageView
import org.koin.android.compat.ViewModelCompat.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context, movie: BaseMovieBean) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("movie", movie)
            context.startActivity(intent)
        }
    }


    private val mViewModel by viewModel<DetailViewModel>()
    private lateinit var ivFavor: MovieFavoritesImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        ivFavor = findViewById(R.id.ivFavor)
        val movie = intent.getSerializableExtra("movie") as BaseMovieBean?
        movie?.let {
            ivFavor.init(it,mViewModel)
        }


    }
}