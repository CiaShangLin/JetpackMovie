package com.shang.jetpackmovie.fragment.favor

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.databinding.FragmentFavorBinding
import com.shang.jetpackmovie.fragment.genres.ui.MovieDecoration
import com.shang.jetpackmovie.ui.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavorFragment : Fragment(R.layout.fragment_favor) {

    private val mBinding by viewBinding(FragmentFavorBinding::bind)
    private val mViewModel by viewModel<FavorViewModel>()
    private val mController by lazy { FavorMovieController(mViewModel) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.rvMovie.layoutManager = GridLayoutManager(requireContext(), 2)
        mBinding.rvMovie.addItemDecoration(MovieDecoration())
        mBinding.rvMovie.setControllerAndBuildModels(mController)

        mViewModel.getAll().observe(viewLifecycleOwner, {
            mController.setData(it)
        })
    }
}
