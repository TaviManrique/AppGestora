package com.manriquetavi.appgestor.data.repository

import com.manriquetavi.appgestor.domain.model.DataOrException
import com.manriquetavi.appgestor.domain.model.Store
import com.manriquetavi.appgestor.domain.repository.FirebaseDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val firebase: FirebaseDataSource
) {
    fun getAllStores(): Flow<DataOrException<List<Store>, Boolean, Exception>> = firebase.getAllStores()
}