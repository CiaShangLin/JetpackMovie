package com.shang.jetpackmovie.activity.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private val navController by lazy { findNavController(R.id.nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        //底層其實實作了setOnItemSelectedListener
        mBinding.navView.setupWithNavController(navController)
    }
}
