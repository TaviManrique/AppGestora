package com.manriquetavi.appgestor.domain.model

import androidx.room.PrimaryKey


data class Product(
    @PrimaryKey(autoGenerate = false)
    val id: String? = "",
    val name: String? = "",
    val salePrice: String? = "",
    val wholesalePrice: String? = ""
)
