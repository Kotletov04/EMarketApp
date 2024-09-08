package com.example.data.repository

import com.example.domain.model.ProductsModel
import com.example.domain.repository.ProductsRepository
import retrofit2.Retrofit
import javax.inject.Inject


class ProductsRepositoryImplementation @Inject constructor(retrofit: Retrofit): ProductsRepository {

    override suspend fun saveProducts(products: ProductsModel) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllProductsFromApi(): List<ProductsModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getProductsByIdFromApi(id: Long): ProductsModel {
        TODO("Not yet implemented")
    }

    override suspend fun getAllProductsInDatabase(): List<ProductsModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getProductsByIdInDatabase(id: Long): ProductsModel {
        TODO("Not yet implemented")
    }
}
