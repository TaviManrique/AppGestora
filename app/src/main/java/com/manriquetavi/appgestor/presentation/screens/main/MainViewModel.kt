package com.manriquetavi.appgestor.presentation.screens.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manriquetavi.appgestor.domain.model.Result
import com.manriquetavi.appgestor.repository.StoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: StoreRepository
): ViewModel() {

    private val _state: MutableState<MainState> = mutableStateOf(MainState())
    val state: State<MainState> = _state

    init {
        getAllStores()
    }

    fun getAllStores() {
        repository.getAllStores().onEach { result ->
            when(result) {
                is Result.Error -> _state.value = MainState(error = result.message ?: "Error unknown")
                is Result.Loading -> _state.value = MainState(isLoading = true)
                is Result.Success -> _state.value = MainState(stores = result.data ?: emptyList())
            }
        }.launchIn(viewModelScope)
    }

}