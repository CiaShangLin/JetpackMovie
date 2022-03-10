package com.shang.jetpackmovie.activity.children.Genre

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.shang.jetpackmovie.activity.children.Base.BaseAdapter
import com.shang.jetpackmovie.activity.children.Base.BaseFragment
import com.shang.jetpackmovie.activity.children.Base.BaseViewModel
import com.shang.jetpackmovie.activity.children.Base.MovieFactory

class GenreFragment : BaseFragment() {
    companion object {
        fun newInstance(id: Int): GenreFragment {
            return GenreFragment().apply {
                this.arguments = Bundle().apply {
                    this.putInt("ID", id)
                }
            }
        }
    }

    override val adapter by lazy { GenreAdapter(viewModel) }
    override val viewModel by lazy {
        ViewModelProvider(this, MovieFactory.create(requireActivity().application, mID))
            .get(GenreViewModel::class.java)
    }

}