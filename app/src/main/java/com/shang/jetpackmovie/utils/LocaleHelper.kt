package com.shang.jetpackmovie.utils

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import java.util.Locale

class LocaleHelper {
    companion object {

        /**
         * 目前做不到直接切換，估計是要直接刷新每個Activity
         * 放在Application不起作用
         */
        fun update(context: Context, language: String) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                updateResources(context, language)
            }
            updateResourcesLegacy(context, language)
        }

        private fun updateResources(context: Context, language: String) {
            val locale = Locale(language)
            Locale.setDefault(locale)

            val configuration: Configuration = context.resources.configuration
            configuration.setLocale(locale)
            configuration.setLayoutDirection(locale)

            context.createConfigurationContext(configuration)
        }

        private fun updateResourcesLegacy(context: Context, language: String): Context? {
            val locale = Locale(language)
            Locale.setDefault(locale)
            val resources: Resources = context.resources
            val configuration: Configuration = resources.configuration
            configuration.locale = locale
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                configuration.setLayoutDirection(locale)
            }
            resources.updateConfiguration(configuration, resources.displayMetrics)
            return context
        }
    }
}
