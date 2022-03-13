package com.santimattius.feature.shared

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.launchFragmentInContainer
import com.santimattius.feature.R


inline fun <reified F : Fragment> launchFragment(init: Bundle.() -> Unit = {}) {
    val args = Bundle()
    args.init()
    launchFragmentInContainer<F>(args, R.style.Theme_AndroidPerformance)
}