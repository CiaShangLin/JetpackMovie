package com.shang.jetpackmovie.activity.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.bean.BaseMovieBean
import com.shang.jetpackmovie.bean.IBaseMovie
import com.shang.jetpackmovie.bean.MovieListBean
import com.shang.jetpackmovie.databinding.ActivityDetailBinding
import com.shang.jetpackmovie.fragment.favor.FavorViewModel
import com.shang.jetpackmovie.ui.MovieFavoritesImageView
import com.shang.jetpackmovie.ui.viewBinding
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


    private lateinit var mBinding : ActivityDetailBinding
    private val mViewModel by viewModel<DetailViewModel>()
    private val mDetailController by lazy { DetailController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val movie = intent.getSerializableExtra("movie") as BaseMovieBean?
        val list = mutableListOf<IBaseMovie>()
        for(i in 0..9){
            list.add(movie!!)
        }

        mBinding.rvDetail.layoutManager = LinearLayoutManager(this)
        mBinding.rvDetail.setControllerAndBuildModels(mDetailController)
        mDetailController.setData(list)

        mBinding.toolbar.title = "123"

    }
}