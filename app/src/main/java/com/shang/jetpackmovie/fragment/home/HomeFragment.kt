package com.shang.jetpackmovie.fragment.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.api.UiState
import com.shang.jetpackmovie.bean.MovieGenreBean
import com.shang.jetpackmovie.databinding.FragmentHomeBinding
import com.shang.jetpackmovie.ui.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val homeViewModel by viewModel<HomeViewModel>()
    private val mBinding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.movieGenres.observe(viewLifecycleOwner, {
            when (it) {
                is UiState.Success -> {
                    setViewPager(it.data.genres)
                }
                is UiState.Failure -> {
                    //考慮彈出Dialog，然後跳回SplashActivity再來一次
                    Log.d("DEBUG", "Failure")
                }
                UiState.Loading -> {
                    Log.d("DEBUG", "Loading")
                }
            }
        })
    }


    private fun setViewPager(genres: List<MovieGenreBean.Genre>) {
        mBinding.viewPager.adapter = HomeViewPagerAdapter(this, genres)
        TabLayoutMediator(mBinding.tabLayout, mBinding.viewPager) { tab, position ->
            tab.setText(genres[position].name)
        }.attach()
    }
}