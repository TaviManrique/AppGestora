package com.manriquetavi.appgestor.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "store_table")
data class Store(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 0,
    val name: String = "",
    val code: Int = 0,
    val address: String = "",
    val latitude: String = "",
    val longitude: String = "",
    val products: List<Product> = emptyList<Product>()
)
