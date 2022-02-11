package com.shang.jetpackmovie.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.annotation.NonNull
import com.shang.jetpackmovie.core.JetpackMovieApplication

class SharedPreUtils {

    companion object {
        private const val Planet_File = "Jetpack_Movie_File"
        private val sharedPreUtils by lazy { SharedPreUtils() }
        fun getInstance(): SharedPreUtils {
            return sharedPreUtils
        }
    }


    fun setValue(key: String, @NonNull value: Any?) {
        val preferences =
            JetpackMovieApplication.context?.getSharedPreferences(Planet_File, Context.MODE_PRIVATE)
        val editor = preferences?.edit()
        commit(editor, key, value)
    }

    //取值 defValue不能傳null 不然一定回傳null給你
    fun <T> getValue(key: String, @NonNull defValue: T): T {
        val preferences = JetpackMovieApplication.context?.getSharedPreferences(Planet_File, Context.MODE_PRIVATE)

        return when (defValue) {
            is String -> preferences?.getString(key, defValue) as T
            is Int -> preferences?.getInt(key, defValue) as T
            is Float -> preferences?.getFloat(key, defValue) as T
            is Long -> preferences?.getLong(key, defValue) as T
            is Boolean -> preferences?.getBoolean(key, defValue) as T
            is MutableSet<*> -> preferences?.getStringSet(key, defValue as MutableSet<String>) as T
            else -> {
                null as T
            }
        }
    }

    //儲存 可以多寫一個apply
    private fun commit(editor: SharedPreferences.Editor?, key: String, value: Any?) {
        if (editor == null) {
            return
        }
        when (value) {
            is String -> editor.putString(key, value)
            is Int -> editor.putInt(key, value)
            is Float -> editor.putFloat(key, value)
            is Long -> editor.putLong(key, value)
            is Boolean -> editor.putBoolean(key, value)
            is MutableSet<*> -> editor.putStringSet(key, value as MutableSet<String>)
        }
        editor.commit()
    }
}