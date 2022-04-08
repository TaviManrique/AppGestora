package com.manriquetavi.appgestor.presentation.screens.main

import com.manriquetavi.appgestor.domain.model.Store

data class MainState(
    val isLoading: Boolean = false,
    val stores: List<Store> = emptyList(),
    val error: String = ""
)
