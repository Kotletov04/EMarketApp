package com.example.domain.repository

import com.example.domain.model.ProductsModel

interface ProductsRepository {

    suspend fun saveProducts(products: ProductsModel)

    suspend fun getAllProductsFromApi(): List<ProductsModel>

    suspend fun getProductsByIdFromApi(id: Long): ProductsModel

    suspend fun getAllProductsInDatabase(): List<ProductsModel>

    suspend fun getProductsByIdInDatabase(id: Long): ProductsModel


}