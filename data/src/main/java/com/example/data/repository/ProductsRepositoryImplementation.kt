package com.example.data.repository

import com.example.data.network.dto.products.toProductsModel
import com.example.data.network.requests.ProductsRequest
import com.example.data.storage.dao.ProductsDao
import com.example.data.storage.entity.ProductsEntity
import com.example.domain.model.ProductsModel
import com.example.domain.repository.ProductsRepository
import retrofit2.Retrofit
import javax.inject.Inject


class ProductsRepositoryImplementation @Inject constructor(

    private val retrofit: Retrofit,
    private val dao: ProductsDao

): ProductsRepository {


    private val productsRequest: ProductsRequest by lazy {
        retrofit.create(ProductsRequest::class.java)
    }


    override suspend fun saveProducts(products: ProductsModel) {
        dao.insertProducts(data = ProductsEntity(
            idProduct = products.id,
            title = products.title,
            description = products.description,
            category = products.category,
            price = products.price,
            discountPercentage = products.discountPercentage,
            rating = products.rating,
            stock = products.stock,
            tags = products.tags,
            brand = products.brand,
            sku = products.sku,
            weight = products.weight,
            dimensions = products.dimensions,
            warrantyInformation = products.warrantyInformation,
            shippingInformation = products.shippingInformation,
            availabilityStatus = products.availabilityStatus,
            reviews = products.reviews,
            returnPolicy = products.returnPolicy,
            minimumOrderQuantity = products.minimumOrderQuantity,
            meta = products.meta,
            images = products.images,
            thumbnail = products.thumbnail

        ))
    }

    override suspend fun getAllProductsFromApi(): List<ProductsModel> {
        val response = productsRequest.requestAllProducts()
        if (response.isSuccessful) {
            return response.body()!!.products.map { it.toProductsModel() }
        } else {
            return listOf(ProductsModel(errorMessage = response.message()))
        }
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
