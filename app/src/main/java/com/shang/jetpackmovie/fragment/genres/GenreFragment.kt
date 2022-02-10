package com.shang.jetpackmovie.fragment.genres

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.shang.jetpackmovie.MovieRefreshHeader
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.bean.MovieGenreBean
import com.shang.jetpackmovie.databinding.FragmentGenreBinding
import com.shang.jetpackmovie.viewBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

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
    private val mGenre by lazy { arguments?.getSerializable(GENRE) as MovieGenreBean.Genre? }
    private val mViewModel by viewModel<GenreViewModel>{ parametersOf(mGenre)}
    private val mGenreController by lazy { GenreController() }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel.genreLiveData.observe(viewLifecycleOwner,{

        })

        mBinding.rvGenre.layoutManager=GridLayoutManager(requireContext(),2)
        mBinding.rvGenre.setControllerAndBuildModels(mGenreController)
    }
}