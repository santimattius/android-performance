package com.santimattius.feature.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santimattius.feature.domain.usecases.GetPictures
import com.santimattius.feature.presentation.models.Data
import com.santimattius.feature.presentation.models.Error
import com.santimattius.feature.presentation.models.HomeState
import com.santimattius.feature.presentation.models.Loading
import com.santimattius.feature.presentation.models.mapping.asUiModels
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class HomeViewModel(private val getPictures: GetPictures) : ViewModel() {

    private val _state = MutableLiveData<HomeState>()
    val state: LiveData<HomeState>
        get() = _state

    private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
        _state.postValue(Error)
    }

    init {
        pictures()
    }

    private fun pictures() {
        viewModelScope.launch(exceptionHandler) {
            _state.postValue(Loading)
            val pictures = getPictures().asUiModels()
            _state.postValue(Data(values = pictures))
        }
    }

    fun retry() {
        pictures()
    }
}

