package com.manriquetavi.appgestor.presentation.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manriquetavi.appgestor.domain.model.DataOrException
import com.manriquetavi.appgestor.domain.model.Store
import com.manriquetavi.appgestor.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    useCases: UseCases
): ViewModel() {

    val getAllStores = useCases.getAllStoresUseCase
    /*
    private val _allStores: MutableStateFlow<DataOrException<List<Store>, Boolean, Exception>> = MutableStateFlow(DataOrException())
    val allStores: StateFlow<DataOrException<List<Store>, Boolean, Exception>> = _allStores

    private fun getAllStores() {
        viewModelScope.launch {
            _allStores.value.loading = true
            useCases.getAllStoresUseCase().collect {
                _allStores.value = it
            }
            if(!_allStores.value.data.isNullOrEmpty()) _allStores.value.loading = false
        }
    }*/

    /*
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
    }*/
}
