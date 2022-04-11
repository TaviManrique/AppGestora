package com.manriquetavi.appgestor.domain.use_cases.sign_out_firebase

import com.manriquetavi.appgestor.data.repository.Repository
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class SignOutFirebase(
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.signOutFirebase()
}