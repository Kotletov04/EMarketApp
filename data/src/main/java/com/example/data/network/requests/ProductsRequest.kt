package com.example.data.network.requests

import com.example.data.network.dto.products.ListProductsDto
import retrofit2.Response
import retrofit2.http.GET

interface ProductsRequest {

    @GET("products")
    suspend fun RequestAllProducts(): Response<ListProductsDto>



}