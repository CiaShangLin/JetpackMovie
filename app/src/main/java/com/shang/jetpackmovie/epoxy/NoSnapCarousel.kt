package com.shang.jetpackmovie.epoxy

import android.content.Context
import android.util.AttributeSet
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.ModelView

@ModelView(saveViewState = true, autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class NoSnapCarousel @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : Carousel(context, attrs) {

    /**
     * getSnapHelperFactory()會去拿取defaultGlobalSnapHelperFactory
     * 如果透過Carousel.setDefaultGlobalSnapHelperFactory(null)會導致全部的Carousel都沒有Snap功能
     * 所以只能自己復寫一個沒有Snap功能的
     */
    override fun getSnapHelperFactory(): SnapHelperFactory? {
        return null
    }
}