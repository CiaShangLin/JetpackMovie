package com.shang.jetpackmovie.fragment.setting

import com.airbnb.epoxy.AutoModel
import com.airbnb.epoxy.EpoxyController
import com.shang.jetpackmovie.fragment.setting.ui.DevelopersModel_
import com.shang.jetpackmovie.fragment.setting.ui.DisclaimerModel_
import com.shang.jetpackmovie.fragment.setting.ui.LanguageModel_
import com.shang.jetpackmovie.fragment.setting.ui.ResolutionModel_
import com.shang.jetpackmovie.fragment.setting.ui.ThemeModel_

class SettingController : EpoxyController() {

    @AutoModel
    lateinit var themeModel: ThemeModel_

    @AutoModel
    lateinit var languageModel: LanguageModel_

    @AutoModel
    lateinit var disclaimer: DisclaimerModel_

    @AutoModel
    lateinit var developersModel: DevelopersModel_

    @AutoModel
    lateinit var resolutionModel: ResolutionModel_

    override fun buildModels() {
        themeModel.addTo(this)
//        languageModel.addTo(this)
//        resolutionModel.addTo(this)
        developersModel.addTo(this)
        disclaimer.addTo(this)
    }
}
