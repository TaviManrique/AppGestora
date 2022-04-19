package com.manriquetavi.appgestor.domain.repository

import com.manriquetavi.appgestor.domain.model.Product
import com.manriquetavi.appgestor.domain.model.Response
import com.manriquetavi.appgestor.domain.model.Store
import kotlinx.coroutines.flow.Flow

interface FirebaseDataSource {
    fun getAllStores(): Flow<Response<List<Store>>>
    fun getSelectedStore(storeId: String): Flow<Response<Store?>>
    fun getAllProductsSelectedStore(storeId: String): Flow<Response<List<Product?>>>
}