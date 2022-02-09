package com.shang.jetpackmovie.glideModule

import com.bumptech.glide.load.model.ModelLoader
import com.bumptech.glide.load.model.ModelLoaderFactory
import com.bumptech.glide.load.model.MultiModelLoaderFactory
import java.nio.ByteBuffer

class MovieModelLoaderFactory : ModelLoaderFactory<String, ByteBuffer> {
    override fun build(multiFactory: MultiModelLoaderFactory): ModelLoader<String, ByteBuffer> = MovieModelLoader()

    override fun teardown() {}
}