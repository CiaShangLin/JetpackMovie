package com.shang.jetpackmovie.api

import com.shang.jetpackmovie.globalData.UserSetting
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

class LanguageInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder().addQueryParameter("language",Locale.getDefault().language).build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }

    fun getLanguage() = when(Locale.getDefault().language) {
        Locale.CHINESE.language -> "zh-TW"
        Locale.ENGLISH.language -> "en-US"
        else -> "zh-TW"
    }
}