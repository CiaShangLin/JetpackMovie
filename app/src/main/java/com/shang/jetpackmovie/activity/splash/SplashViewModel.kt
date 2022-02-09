package com.shang.jetpackmovie.activity.splash

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
//import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.shang.jetpackmovie.bean.ConfigurationBean
import com.shang.jetpackmovie.globalData.Configuration
import kotlinx.coroutines.launch

class SplashViewModel(application: Application,private val splashRepository: SplashRepository) : AndroidViewModel(application) {

    val liveData = liveData<ConfigurationBean> {
        val configuration = splashRepository.getConfiguration()
        Configuration.setConfiguration(configuration)
        emit(configuration)
    }

}