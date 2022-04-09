package com.manriquetavi.appgestor.domain.use_cases.get_all_stores

import com.manriquetavi.appgestor.data.repository.Repository
import com.manriquetavi.appgestor.domain.model.DataOrException
import com.manriquetavi.appgestor.domain.model.Store
import kotlinx.coroutines.flow.Flow

class GetAllStoresUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<DataOrException<List<Store>, Boolean, Exception>> = repository.getAllStores()
}