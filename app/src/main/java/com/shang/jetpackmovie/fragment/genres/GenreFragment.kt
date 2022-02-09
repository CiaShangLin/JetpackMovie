package com.shang.jetpackmovie.fragment.genres

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.bean.MovieGenreBean
import com.shang.jetpackmovie.databinding.FragmentGenreBinding
import com.shang.jetpackmovie.viewBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class GenreFragment : Fragment(R.layout.fragment_genre) {
    companion object {
        private const val GENRE = "GENRE"
        fun newInstance(genre: MovieGenreBean.Genre): GenreFragment {
            return GenreFragment().apply {
                this.arguments = Bundle().apply {
                    this.putSerializable(GENRE, genre)
                }
            }
        }
    }

    private val mBinding by viewBinding(FragmentGenreBinding::bind)
    private val mViewModel by viewModel<GenreViewModel>()
    private val mGenre by lazy { arguments?.getSerializable(GENRE) as MovieGenreBean.Genre? }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel.livedata.observe(viewLifecycleOwner,{

        })
    }
}