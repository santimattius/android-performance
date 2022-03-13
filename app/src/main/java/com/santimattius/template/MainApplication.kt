package com.santimattius.template

import android.app.Application
import com.santimattius.feature.di.FeatureModule

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        FeatureModule.init(app = this)
    }
}