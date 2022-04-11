package com.manriquetavi.appgestor.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.manriquetavi.appgestor.domain.model.Response
import com.manriquetavi.appgestor.domain.repository.FirebaseAuthSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton


@ExperimentalCoroutinesApi
@Singleton
class FirebaseAuthSourceImpl @Inject constructor(
    private val auth: FirebaseAuth
): FirebaseAuthSource{

    override fun isUserAuthenticatedInFirebase(): Boolean = auth.currentUser != null

    override suspend fun firebaseSignInWithEmailAndPassword(email: String, password: String): Flow<Response<Boolean>>  = flow {
        try {
            emit(Response.Loading)
            auth.signInWithEmailAndPassword(email, password).await()
            emit(Response.Success(true))
        } catch (e: Exception) {
            emit(Response.Error(e.message ?: e.toString()))
        }
    }

    override suspend fun signOutFirebase(): Flow<Response<Boolean>> = flow {
        try {
            emit(Response.Loading)
            auth.currentUser?.apply {
                delete().await()
                emit(Response.Success(true))
            }
        } catch (e: Exception) {
            emit(Response.Error(e.message ?: e.toString()))
        }
    }

    override fun getFirebaseAuthState(): Flow<Boolean> = callbackFlow  {
        val authStateListener = FirebaseAuth.AuthStateListener { auth ->
            trySend(auth.currentUser == null)
        }
        auth.addAuthStateListener(authStateListener)
        awaitClose {
            auth.removeAuthStateListener(authStateListener)
        }
    }

}