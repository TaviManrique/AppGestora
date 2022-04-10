package com.manriquetavi.appgestor.presentation.screens.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manriquetavi.appgestor.domain.model.Response
import com.manriquetavi.appgestor.domain.model.Store
import com.manriquetavi.appgestor.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {
    private val _storesState = mutableStateOf<Response<List<Store>>>(Response.Loading)
    val storesState: State<Response<List<Store>>> = _storesState

    init {
        getBooks()
    }

    private fun getBooks() {
        viewModelScope.launch {
            useCases.getAllStoresUseCase().collect {
                _storesState.value = it
            }
        }
    }
}
