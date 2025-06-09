package com.shang.jetpackmovie.glideModule

import androidx.annotation.Nullable
import com.bumptech.glide.load.Options
import com.bumptech.glide.load.model.ModelLoader
import com.bumptech.glide.signature.ObjectKey
import java.nio.ByteBuffer

class MovieModelLoader : ModelLoader<String, ByteBuffer> {

    @Nullable
    override fun buildLoadData(model: String, width: Int, height: Int, options: Options): ModelLoader.LoadData<ByteBuffer> {
        return ModelLoader.LoadData(ObjectKey(model), MovieDataFetcher(model))
    }

    override fun handles(model: String): Boolean {
        return model.startsWith("/") && model.endsWith("jpg")
    }
}
