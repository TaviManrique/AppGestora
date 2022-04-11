package com.manriquetavi.appgestor.domain.use_cases.sign_in.email_password

import com.manriquetavi.appgestor.data.repository.Repository
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class SignInWithEmailAndPassword(
    private val repository: Repository
) {
    suspend operator fun invoke(email: String, password: String)
    = repository.firebaseSignInWithEmailAndPassword(email,password)
}