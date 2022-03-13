package com.santimattius.feature

import android.app.Application
import com.santimattius.feature.di.FeatureModule

class EspressoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        FeatureModule.init(app = this)
    }
}