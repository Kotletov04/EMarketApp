package com.example.domain.model

data class ProductsModel(

    var id: Long,

    var title: String,

    var description: String,

    var category: String,

    var price: Float,

    var discountPercentage: Float,

    var rating: Float,

    var stock: Long,

    var tags: List<String>,

    var brand: String,

    var sku: String,

    var weight: Float,

    var dimensions: DimensionsModel,

    var warrantyInformation: String,

    var shippingInformation: String,

    var availabilityStatus: String,

    var reviews: List<ReviewsModel>,

    var returnPolicy: String,

    var minimumOrderQuantity: Int,

    var meta: MetaModel,

    var images: List<String>,

    var thumbnail: String

)
