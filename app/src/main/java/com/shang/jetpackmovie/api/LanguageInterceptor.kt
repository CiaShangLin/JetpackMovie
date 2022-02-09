package com.shang.jetpackmovie.api

import okhttp3.Interceptor
import okhttp3.Response

class LanguageInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder().addQueryParameter("language", "zh-TW").build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}