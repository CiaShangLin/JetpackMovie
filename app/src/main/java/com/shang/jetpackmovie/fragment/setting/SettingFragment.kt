package com.shang.jetpackmovie.fragment.setting

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.databinding.FragmentSettingBinding
import com.shang.jetpackmovie.ui.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingFragment : Fragment(R.layout.fragment_setting) {

    private val mBinding by viewBinding(FragmentSettingBinding::bind)
    private val mViewModel by viewModel<SettingViewModel>()
    private val mController by lazy { SettingController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.rvSetting.setControllerAndBuildModels(mController)
        mBinding.rvSetting.addItemDecoration(SettingDecoration(requireContext()))
    }
}
