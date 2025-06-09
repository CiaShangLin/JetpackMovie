package com.shang.jetpackmovie.fragment.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.shang.jetpackmovie.bean.MovieGenreBean
import com.shang.jetpackmovie.fragment.genres.GenreFragment

class HomeViewPagerAdapter(
    fragment: Fragment,
    private val genres: List<MovieGenreBean.Genre>,
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = genres.size

    override fun createFragment(position: Int): Fragment =
        GenreFragment.newInstance(genres[position])
}
