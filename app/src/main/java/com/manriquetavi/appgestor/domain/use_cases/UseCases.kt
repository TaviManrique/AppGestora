package com.manriquetavi.appgestor.domain.use_cases

import com.manriquetavi.appgestor.domain.use_cases.get_all_stores.GetAllStoresUseCase
import com.manriquetavi.appgestor.domain.use_cases.sign_in.email_password.SignInWithEmailAndPassword
import com.manriquetavi.appgestor.domain.use_cases.sign_out_firebase.SignOutFirebase
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
data class UseCases(
    val getAllStoresUseCase: GetAllStoresUseCase,
    val signInWithEmailAndPassword: SignInWithEmailAndPassword,
    val signOutFirebase: SignOutFirebase
)