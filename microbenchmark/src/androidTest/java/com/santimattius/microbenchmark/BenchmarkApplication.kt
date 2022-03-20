package com.santimattius.microbenchmark

import android.app.Application
import com.santimattius.feature.di.FeatureModule
import com.santimattius.feature.domain.repositories.PicturesRepository

class BenchmarkApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        FeatureModule.init(app = this) {
            single<PicturesRepository> { FakePicturesRepository() }
        }
    }
}