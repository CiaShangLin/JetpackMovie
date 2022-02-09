package com.shang.jetpackmovie.activity.splash

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.shang.jetpackmovie.activity.main.MainActivity
import com.shang.jetpackmovie.databinding.ActivitySplashBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    private val viewModel by viewModel<SplashViewModel>()
    private lateinit var mBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        viewModel.liveData.observe(this, {

        })
        mBinding.splash.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {

            }

            override fun onAnimationCancel(animation: Animator?) {

            }

            override fun onAnimationRepeat(animation: Animator?) {
                if (viewModel.liveData.value != null) {
                    mBinding.splash.cancelAnimation()
                    val intent = Intent(this@SplashActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        })
    }
}