package com.manriquetavi.appgestor.domain.use_cases.get_all_products_selected_store

import com.manriquetavi.appgestor.data.repository.Repository
import com.manriquetavi.appgestor.domain.model.Product
import com.manriquetavi.appgestor.domain.model.Response
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
class GetAllProductsSelectedStoreUseCase(
    private val repository: Repository
) {
    operator fun invoke(storeId: String): Flow<Response<List<Product?>>> = repository.getAllProductsSelectedStore(storeId)
}