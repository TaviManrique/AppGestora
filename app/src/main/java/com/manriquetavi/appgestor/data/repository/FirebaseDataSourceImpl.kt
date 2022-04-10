package com.manriquetavi.appgestor.data.repository

import com.google.firebase.firestore.Query

import com.manriquetavi.appgestor.domain.model.Response.*
import com.manriquetavi.appgestor.domain.model.Store
import com.manriquetavi.appgestor.domain.repository.FirebaseDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

@ExperimentalCoroutinesApi
class FirebaseDataSourceImpl(
    private val queryAllStores: Query
): FirebaseDataSource {

    override fun getAllStores() = callbackFlow {
        val snapshotListener = queryAllStores.addSnapshotListener { snapshot, e ->
            val response = if (snapshot != null) {
                val stores = snapshot.toObjects(Store::class.java)
                Success(stores)
            } else {
                Error(e?.message ?: e.toString())
            }
            trySend(response).isSuccess
        }
        awaitClose {
            snapshotListener.remove()
        }
    }
}