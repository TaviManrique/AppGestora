package com.manriquetavi.appgestor.data.repository

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.manriquetavi.appgestor.domain.model.Product
import com.manriquetavi.appgestor.domain.model.Response
import com.manriquetavi.appgestor.domain.model.Store
import com.manriquetavi.appgestor.domain.repository.FirebaseDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

@ExperimentalCoroutinesApi
class FirebaseDataSourceImpl (
    private val queryAllStores: FirebaseFirestore
): FirebaseDataSource {

    override fun getAllStores(): Flow<Response<List<Store>>> = callbackFlow {
        val snapshotListener = queryAllStores.collection("stores").addSnapshotListener { snapshot, e ->
            val response = if (snapshot != null) {
                val stores = snapshot.toObjects(Store::class.java)
                Response.Success(stores)
            } else {
                Response.Error(e?.message ?: e.toString())
            }
            trySend(response).isSuccess
        }
        awaitClose {
            snapshotListener.remove()
        }
    }

    override fun getSelectedStore(storeId: String): Flow<Response<Store?>> = callbackFlow {
        val document = queryAllStores.collection("stores").document(storeId).get().addOnSuccessListener { document ->
            val response = if(document != null) {
                val store = document.toObject(Store::class.java)
                Log.d("TAG", "DocumentSnapshot data: ${document.data}")
                Response.Success(store)
            } else {
                Response.Error("No such document")
            }
            trySend(response).isSuccess
        }
            .addOnFailureListener { e ->
                trySend(Response.Error(e.message ?: e.toString())).isSuccess
            }
        awaitClose {
            document.isCanceled
        }
    }

    override fun getAllProductsSelectedStore(storeId: String): Flow<Response<List<Product?>>> = callbackFlow {
        val snapshotListener = queryAllStores.collection("stores").document(storeId).collection("products").addSnapshotListener { snapshot, e ->
            val response = if (snapshot != null) {
                val products = snapshot.toObjects(Product::class.java)
                Response.Success(products)
            } else {
                Response.Error(e?.message ?: e.toString())
            }
            trySend(response).isSuccess
        }
        awaitClose {
            snapshotListener.remove()
        }
    }
}