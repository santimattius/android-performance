package com.santimattius.feature.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.santimattius.feature.databinding.ActivityMainBinding
import com.santimattius.feature.presentation.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    lateinit var fragment: HomeFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        fragment = viewBinding.fragmentContainerView.getFragment()
    }
}