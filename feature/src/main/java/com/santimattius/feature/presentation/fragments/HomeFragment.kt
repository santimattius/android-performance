package com.santimattius.feature.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.santimattius.feature.R
import com.santimattius.feature.core.presentation.DialogAction
import com.santimattius.feature.core.presentation.openLink
import com.santimattius.feature.core.presentation.showDialog
import com.santimattius.feature.databinding.HomeFragmentBinding
import com.santimattius.feature.presentation.adapters.HomeAdapter
import com.santimattius.feature.presentation.models.Data
import com.santimattius.feature.presentation.models.Error
import com.santimattius.feature.presentation.models.HomeState
import com.santimattius.feature.presentation.models.Loading
import com.santimattius.feature.presentation.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModel()

    // It's used in benchmarks
    @Suppress("MemberVisibilityCanBePrivate")
    val adapter: HomeAdapter by lazy {
        HomeAdapter {
            openLink(it.imageUrl)
        }
    }

    private lateinit var viewBinding: HomeFragmentBinding

    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        viewBinding = HomeFragmentBinding.inflate(inflater, container, false).apply {
            this.homePictures.layoutManager = LinearLayoutManager(this.homePictures.context)
            this.homePictures.adapter = adapter
        }
        this.recyclerView = viewBinding.homePictures
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner, ::onStateChange)
    }

    private fun onStateChange(state: HomeState) {
        when (state) {
            is Data -> {
                loading(visible = false)
                viewBinding.textEmptyResult.isVisible = state.values.isEmpty()
                adapter.submitList(state.values)
            }
            Error -> {
                loading(visible = false)
                showError()
            }
            Loading -> {
                loading(visible = true)
            }
        }
    }

    private fun showError() {
        showDialog(
            message = getString(R.string.message_loading_error),
            positiveAction = DialogAction(text = getString(R.string.button_text_positive_error)) {
                viewModel.retry()
            },
            negativeAction = DialogAction(text = getString(R.string.button_text_negative_error)) {
                requireActivity().finish()
            }
        )
    }


    private fun loading(visible: Boolean) = run { viewBinding.homeProgressBar.isVisible = visible }

}