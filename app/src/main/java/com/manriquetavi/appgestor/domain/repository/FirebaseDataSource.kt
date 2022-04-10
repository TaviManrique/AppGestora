package com.manriquetavi.appgestor.domain.repository

import com.manriquetavi.appgestor.domain.model.Response
import com.manriquetavi.appgestor.domain.model.Store
import kotlinx.coroutines.flow.Flow

interface FirebaseDataSource {
    fun getAllStores(): Flow<Response<List<Store>>>
}