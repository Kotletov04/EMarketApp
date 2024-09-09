package com.example.data.network.dto.products

import com.example.domain.model.ProductsModel
import com.google.gson.annotations.SerializedName


data class ProductsDto(

    @SerializedName("id")
    var id: Long,

    @SerializedName("title")
    var title: String,

    @SerializedName("description")
    var description: String,

    @SerializedName("category")
    var category: String,

    @SerializedName("price")
    var price: Float,

    @SerializedName("discountPercentage")
    var discountPercentage: Float,

    @SerializedName("rating")
    var rating: Float,

    @SerializedName("stock")
    var stock: Long,

    @SerializedName("tags")
    var tags: List<String>,

    @SerializedName("brand")
    var brand: String,

    @SerializedName("sku")
    var sku: String,

    @SerializedName("weight")
    var weight: Float,

    @SerializedName("dimensions")
    var dimensions: DimensionsDto,

    @SerializedName("warrantyInformation")
    var warrantyInformation: String,

    @SerializedName("shippingInformation")
    var shippingInformation: String,

    @SerializedName("availabilityStatus")
    var availabilityStatus: String,

    @SerializedName("reviews")
    var reviews: List<ReviewsDto>,

    @SerializedName("returnPolicy")
    var returnPolicy: String,

    @SerializedName("minimumOrderQuantity")
    var minimumOrderQuantity: Int,

    @SerializedName("meta")
    var meta: MetaDto,

    @SerializedName("images")
    var images: List<String>,

    @SerializedName("thumbnail")
    var thumbnail: String

)

fun ProductsDto.toProductsModel(): ProductsModel {
    return ProductsModel(
        id = id,
        title = title,
        description = description,
        category = category,
        price = price,
        discountPercentage = discountPercentage,
        rating = rating,
        stock = stock,
        tags = tags,
        brand = brand,
        sku = sku,
        weight = weight,
        dimensions = dimensions.toDimensionsModel(),
        warrantyInformation = warrantyInformation,
        shippingInformation = shippingInformation,
        availabilityStatus = availabilityStatus,
        reviews = reviews.map { it.toReviewsModel() },
        returnPolicy = returnPolicy,
        minimumOrderQuantity = minimumOrderQuantity,
        meta = meta.toMetaModel(),
        images = images,
        thumbnail = thumbnail


    )
}