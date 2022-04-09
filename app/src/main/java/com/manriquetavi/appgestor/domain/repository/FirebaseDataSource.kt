package com.manriquetavi.appgestor.domain.repository

import com.manriquetavi.appgestor.domain.model.DataOrException
import com.manriquetavi.appgestor.domain.model.Store
import kotlinx.coroutines.flow.Flow

interface FirebaseDataSource {
    fun getAllStores(): Flow<DataOrException<List<Store>, Boolean, Exception>>
}