package com.manriquetavi.appgestor.presentation.screens.login


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manriquetavi.appgestor.domain.model.Response
import com.manriquetavi.appgestor.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel(

) {

    private val _sigInState = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val signInState: State<Response<Boolean>> = _sigInState

    private val _email = mutableStateOf("")
    val email = _email

    private val _password = mutableStateOf("")
    val password = _password

    fun sigIn(email: String, password: String) {
        viewModelScope.launch {
            useCases.signInWithEmailAndPassword(email,password).collect { response ->
                _sigInState.value = response
            }
        }
    }
}

