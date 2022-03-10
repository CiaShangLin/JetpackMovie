package com.shang.jetpackmovie.activity.children.Base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shang.jetpackmovie.R

abstract class BaseFragment : Fragment() {

    companion object {
        const val ID = "ID"
    }

    protected val mID by lazy { arguments?.getInt(ID)!! }
    protected lateinit var rvVideo: RecyclerView
    protected abstract val adapter: BaseAdapter
    protected abstract val viewModel: BaseViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_base, container, false)
        rvVideo = view.findViewById(R.id.rvVideo)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvVideo.layoutManager = getLayoutManager()
        rvVideo.adapter = adapter
        if (rvVideo.itemDecorationCount == 0) {
            rvVideo.addItemDecoration(getDecoration())
        }

        viewModel.movieLiveData.observe(viewLifecycleOwner) {
            when (it) {
                UiState.Failure -> {

                }
                UiState.Loading -> {

                }
                UiState.NoMore -> {

                }
                is UiState.Success -> {
                    adapter.submitList(it.data)
                }
            }
        }
    }

    protected open fun getDecoration() = TwoDecoration()

    protected open fun getLayoutManager(): RecyclerView.LayoutManager {
        return GridLayoutManager(requireContext(), 2)
    }

}