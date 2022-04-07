package com.manriquetavi.appgestor.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "store_table")
data class Store(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val code: Int,
    val address: String,
    val products: List<Product>
)
