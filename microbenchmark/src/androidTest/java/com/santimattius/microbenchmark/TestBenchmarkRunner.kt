package com.santimattius.microbenchmark

import android.app.Application
import android.content.Context
import androidx.benchmark.junit4.AndroidBenchmarkRunner

class TestBenchmarkRunner: AndroidBenchmarkRunner() {

    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, BenchmarkApplication::class.java.name, context)
    }
}