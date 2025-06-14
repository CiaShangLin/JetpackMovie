package com.shang.jetpackmovie.activity.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.appbar.AppBarLayout
import com.shang.jetpackmovie.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailActivity : AppCompatActivity() {

    companion object {
        private const val ID = "ID"
        fun start(context: Context, id: Int) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(ID, id)
            context.startActivity(intent)
        }
    }

    private lateinit var mBinding: ActivityDetailBinding
    private val _id by lazy { intent.getIntExtra(ID, -1) }
    private val mViewModel by viewModel<DetailViewModel> { parametersOf(_id) }
    private val mDetailController by lazy { DetailController(mViewModel) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        initView()
        initViewModel()
    }

    private fun initView() {
        mBinding.toolbar.setNavigationOnClickListener {
            finish()
        }

        mBinding.rvDetail.layoutManager = LinearLayoutManager(this)
        mBinding.rvDetail.setController(mDetailController)

        mBinding.appBarLayout.addOnOffsetChangedListener(
            AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
                if (verticalOffset == 0) {
                    mBinding.toolbar.title = ""
                } else if (verticalOffset == appBarLayout.totalScrollRange * -1) {
                    mBinding.toolbar.title = "${mViewModel.detailLiveData.value?.title}"
                }
                mBinding.voteAverageView.alpha =
                    1 - (verticalOffset.toFloat() / (appBarLayout.totalScrollRange * -1))
            },
        )
    }

    private fun initViewModel() {
        mViewModel.detailLiveData.observe(this) {
            Glide.with(this)
                .load(it.poster_path)
                .into(mBinding.ivPoster)

            mDetailController.setDetailBean(it)
        }
        mViewModel.actorLiveData.observe(this) {
            mDetailController.setActorBean(it)
        }
        mViewModel.guessLikeLiveData.observe(this) {
            mDetailController.setGuessLike(it)
        }
    }
}
