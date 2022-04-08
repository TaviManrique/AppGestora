package com.manriquetavi.appgestor.repository

import com.google.firebase.firestore.CollectionReference
import com.manriquetavi.appgestor.domain.model.Result
import com.manriquetavi.appgestor.domain.model.Store
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class StoreRepository @Inject constructor(
    private val stores: CollectionReference
) {

    fun getAllStores(): Flow<Result<List<Store>>> = flow {
        try {
            emit(Result.Loading<List<Store>>())
            val stores = stores.get().await().map { document ->
                document.toObject(Store::class.java)
            }
            emit(Result.Success<List<Store>>(data = stores))
        } catch (e: Exception) {
            emit(Result.Error<List<Store>>(message = e.localizedMessage ?: "Error unknown"))
        }
    }
}