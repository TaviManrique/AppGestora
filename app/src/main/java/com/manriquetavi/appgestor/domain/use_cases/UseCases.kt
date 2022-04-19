package com.manriquetavi.appgestor.domain.use_cases

import com.manriquetavi.appgestor.domain.use_cases.get_all_products_selected_store.GetAllProductsSelectedStoreUseCase
import com.manriquetavi.appgestor.domain.use_cases.get_all_stores.GetAllStoresUseCase
import com.manriquetavi.appgestor.domain.use_cases.get_selected_store.GetSelectedStoreUseCase
import com.manriquetavi.appgestor.domain.use_cases.sign_in.email_password.SignInWithEmailAndPassword
import com.manriquetavi.appgestor.domain.use_cases.sign_out_firebase.SignOutFirebase
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
data class UseCases(
    val getAllStoresUseCase: GetAllStoresUseCase,
    val getSelectedStoreUseCase: GetSelectedStoreUseCase,
    val getAllProductsSelectedStoreUseCase: GetAllProductsSelectedStoreUseCase,
    val signInWithEmailAndPassword: SignInWithEmailAndPassword,
    val signOutFirebase: SignOutFirebase
)