package com.santimattius.feature.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.ModuleDeclaration
import org.koin.dsl.module

class FeatureModule {

    companion object {

        fun init(app: Application, moduleDeclaration: ModuleDeclaration = {}) {
            startKoin {
                androidLogger(Level.NONE)
                androidContext(app)
                modules(modules + listOf(module(moduleDeclaration = moduleDeclaration)))
            }
        }
    }
}