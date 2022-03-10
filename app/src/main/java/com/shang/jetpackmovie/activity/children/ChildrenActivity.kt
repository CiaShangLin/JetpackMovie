package com.shang.jetpackmovie.activity.children

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shang.jetpackmovie.R
import com.shang.jetpackmovie.activity.children.Genre.GenreFragment
import com.shang.jetpackmovie.databinding.ActivityChildrenBinding
import com.shang.jetpackmovie.ui.viewBinding

class ChildrenActivity : AppCompatActivity() {

    companion object {
        private const val ID = "ID"
        fun start(context: Context, id: Int) {
            val intent = Intent(context, ChildrenActivity::class.java)
            intent.putExtra(ID, id)
            context.startActivity(intent)
        }
    }

    private val mID by lazy { intent.getIntExtra(ID,-1) }
    private lateinit var mBinding: ActivityChildrenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityChildrenBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container,GenreFragment.newInstance(mID))
            .commit()

    }
}