package com.manriquetavi.appgestor.data.repository

import com.manriquetavi.appgestor.domain.model.Product
import com.manriquetavi.appgestor.domain.model.Response
import com.manriquetavi.appgestor.domain.model.Store
import com.manriquetavi.appgestor.domain.repository.FirebaseAuthSource
import com.manriquetavi.appgestor.domain.repository.FirebaseDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalCoroutinesApi
class Repository
@Inject constructor(
    private val firebase: FirebaseDataSource,
    private val firebaseAuth: FirebaseAuthSource
) {

    //FireStore
    fun getAllStores(): Flow<Response<List<Store>>>
    = firebase.getAllStores()

    fun getSelectedStore(storeId: String): Flow<Response<Store?>>
    = firebase.getSelectedStore(storeId)

    fun getAllProductsSelectedStore(storeId: String): Flow<Response<List<Product?>>>
    = firebase.getAllProductsSelectedStore(storeId)

    //Firebase Auth
    fun isUserAuthenticatedInFirebase(): Boolean
    = firebaseAuth.isUserAuthenticatedInFirebase()

    suspend fun signOutFirebase(): Flow<Response<Boolean>>
    = firebaseAuth.signOutFirebase()

    suspend fun firebaseSignInWithEmailAndPassword(email: String, password: String): Flow<Response<Boolean>>
    = firebaseAuth.firebaseSignInWithEmailAndPassword(email, password)
    fun getFirebaseAuthState(): Flow<Boolean> = firebaseAuth.getFirebaseAuthState()

}