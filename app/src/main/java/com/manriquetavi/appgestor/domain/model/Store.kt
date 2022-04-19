package com.manriquetavi.appgestor.domain.model

import androidx.room.PrimaryKey


data class Store(
    @PrimaryKey(autoGenerate = false)
    val id: String? = "",
    val name: String? = "",
    val code: Int? = 0,
    val address: String? = "",
    val latitude: String? = "",
    val longitude: String? = ""
)
