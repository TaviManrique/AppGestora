package com.manriquetavi.appgestor.domain.use_cases.get_selected_store

import com.manriquetavi.appgestor.data.repository.Repository
import com.manriquetavi.appgestor.domain.model.Response
import com.manriquetavi.appgestor.domain.model.Store
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
class GetSelectedStoreUseCase(
    private val repository: Repository
) {
    operator fun invoke(storeId: String): Flow<Response<Store?>> = repository.getSelectedStore(storeId)
}