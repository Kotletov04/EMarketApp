package com.example.data.network.dto.products

import com.google.gson.annotations.SerializedName

data class ListProductsDto(

    @SerializedName("products")
    var products: List<ProductsDto>,

    @SerializedName("total")
    var total: Long,

    @SerializedName("skip")
    var skip: Long,

    @SerializedName("limit")
    var limit: Long

)
