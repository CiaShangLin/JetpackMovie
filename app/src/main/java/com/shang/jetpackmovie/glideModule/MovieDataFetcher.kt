package com.shang.jetpackmovie.glideModule

import com.bumptech.glide.Priority
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.data.DataFetcher
import com.shang.jetpackmovie.api.ApiService
import com.shang.jetpackmovie.globalData.Configuration
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.nio.ByteBuffer

class MovieDataFetcher(val model: String) : DataFetcher<ByteBuffer> {

    private var mCall: Call<ResponseBody>? = null

    override fun loadData(priority: Priority, callback: DataFetcher.DataCallback<in ByteBuffer>) {
        val base_url = Configuration.getConfiguration()?.images?.base_url
        // 組成規則BaseUrl+Size+ImageUrl
        val url = "${base_url}original$model"
        mCall = ApiService.movieApi.getPicture(url)
        mCall?.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val bytes = response.body()?.bytes()
                if (bytes != null) {
                    callback.onDataReady(ByteBuffer.wrap(bytes))
                } else {
                    cancel()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                cancel()
            }
        })
    }

    override fun cleanup() {
        mCall?.cancel()
    }

    override fun cancel() {
        mCall?.cancel()
    }

    override fun getDataClass(): Class<ByteBuffer> = ByteBuffer::class.java

    override fun getDataSource(): DataSource = DataSource.REMOTE
}
