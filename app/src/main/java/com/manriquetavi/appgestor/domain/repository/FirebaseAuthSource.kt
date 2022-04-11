package com.manriquetavi.appgestor.domain.repository

import com.manriquetavi.appgestor.domain.model.Response
import kotlinx.coroutines.flow.Flow

interface FirebaseAuthSource {

    fun isUserAuthenticatedInFirebase(): Boolean

    suspend fun firebaseSignInWithEmailAndPassword(email: String, password: String): Flow<Response<Boolean>>

    suspend fun signOutFirebase(): Flow<Response<Boolean>>

    fun getFirebaseAuthState(): Flow<Boolean>
}