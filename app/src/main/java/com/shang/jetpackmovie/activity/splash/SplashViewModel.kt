package com.shang.jetpackmovie.activity.splash

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.liveData
import com.shang.jetpackmovie.bean.ConfigurationBean
import com.shang.jetpackmovie.globalData.Configuration

class SplashViewModel(application: Application, private val splashRepository: SplashRepository) : AndroidViewModel(application) {

    val liveData = liveData<ConfigurationBean> {
        val configuration = splashRepository.getConfiguration()
        Configuration.setConfiguration(configuration)
        emit(configuration)
    }
}
