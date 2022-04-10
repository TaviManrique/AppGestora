package com.manriquetavi.appgestor.domain.use_cases.get_all_stores

import com.manriquetavi.appgestor.data.repository.Repository
import com.manriquetavi.appgestor.domain.model.Response
import com.manriquetavi.appgestor.domain.model.Store
import kotlinx.coroutines.flow.Flow

class GetAllStoresUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Response<List<Store>>> = repository.getAllStores()
}