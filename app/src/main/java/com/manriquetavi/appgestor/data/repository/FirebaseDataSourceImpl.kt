package com.manriquetavi.appgestor.data.repository

import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.Query
import com.manriquetavi.appgestor.domain.model.DataOrException
import com.manriquetavi.appgestor.domain.model.Store
import com.manriquetavi.appgestor.domain.repository.FirebaseDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class FirebaseDataSourceImpl(
    private val queryAllStores: Query
): FirebaseDataSource {

    override fun getAllStores(): Flow<DataOrException<List<Store>, Boolean, Exception>> = flow {
        val dataOrException = DataOrException<List<Store>, Boolean, Exception>()
        try {
            dataOrException.loading = true
            dataOrException.data = queryAllStores.get().await().documents.map { document ->
                document.toObject(Store::class.java)!!
            }
            if (!dataOrException.data.isNullOrEmpty()) dataOrException.loading = false
            emit(dataOrException)
        } catch (e: FirebaseFirestoreException) {
            dataOrException.e = e
            emit(dataOrException)
        }
    }
}