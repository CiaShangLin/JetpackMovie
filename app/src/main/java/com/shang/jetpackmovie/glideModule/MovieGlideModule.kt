package com.shang.jetpackmovie.glideModule

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import java.nio.ByteBuffer

@GlideModule
class MovieGlideModule : AppGlideModule() {
    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.prepend(
            String::class.java,
            ByteBuffer::class.java,
            MovieModelLoaderFactory(),
        )
    }
}
