package com.manriquetavi.appgestor.presentation.screens.report

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manriquetavi.appgestor.domain.model.Product
import com.manriquetavi.appgestor.domain.model.Response
import com.manriquetavi.appgestor.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class ReportViewModel @Inject constructor(
    private val useCases: UseCases,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _productsState = mutableStateOf<Response<List<Product?>>>(Response.Loading)
    val productsState: State<Response<List<Product?>>> = _productsState

    init {
        getProductsState()
    }

    private fun getProductsState() {
        viewModelScope.launch {
            val storeId = savedStateHandle.get<String>("storeId")
            storeId?.let {
                useCases.getAllProductsSelectedStoreUseCase(storeId).collect {
                    _productsState.value = it
                }
            }
        }
        Log.d("TAG", "getProductsSelectedStore: ${_productsState.value}")
    }
}