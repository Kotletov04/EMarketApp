package com.example.testing.ui.mainscreen

import com.example.domain.model.ProductsModel

data class MainScreenState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: ProductsModel? = null
)