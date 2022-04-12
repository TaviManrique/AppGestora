package com.manriquetavi.appgestor.presentation.screens.visit

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manriquetavi.appgestor.domain.model.Response
import com.manriquetavi.appgestor.domain.model.Store
import com.manriquetavi.appgestor.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class VisitViewModel @Inject constructor(
    private val useCases: UseCases,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _selectedStore: MutableState<Response<Store?>> = mutableStateOf(Response.Loading)
    val selectedStore: State<Response<Store?>> = _selectedStore

    init {
        getStoreSelected()
    }

    private fun getStoreSelected() {
        viewModelScope.launch {
            val storeId = savedStateHandle.get<String>("storeId")
            storeId?.let {
                useCases.getSelectedStoreUseCase(storeId).collect {
                    _selectedStore.value = it
                }
            }
        }
        Log.d("TAG", "getStoreSelected: ${_selectedStore.value}")
    }
}