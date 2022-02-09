package com.shang.jetpackmovie.fragment.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.databinding.FragmentSettingBinding
import com.shang.jetpackmovie.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingFragment : Fragment(R.layout.fragment_setting) {

    private val mBinding by viewBinding(FragmentSettingBinding::bind)
    private val mViewModel by viewModel<SettingViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        MODE_NIGHT_NO：強制不使用夜間主題
//        MODE_NIGHT_YES：強制使用夜間主題
//        MODE_NIGHT_AUTO：根據當前時間自動切換 夜間/非夜間主題
//        MODE_NIGHT_FOLLOW_SYSTEM：預設設定，跟隨系統主題
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }
}