package com.example.domain.model

data class ProductsModel(

    var id: Long? = null,

    var title: String? = null,

    var description: String? = null,

    var category: String? = null,

    var price: Float? = null,

    var discountPercentage: Float? = null,

    var rating: Float? = null,

    var stock: Long? = null,

    var tags: List<String>? = null,

    var brand: String? = null,

    var sku: String? = null,

    var weight: Float? = null,

    var dimensions: DimensionsModel? = null,

    var warrantyInformation: String? = null,

    var shippingInformation: String? = null,

    var availabilityStatus: String? = null,

    var reviews: List<ReviewsModel>? = null,

    var returnPolicy: String? = null,

    var minimumOrderQuantity: Int? = null,

    var meta: MetaModel? = null,

    var images: List<String>? = null,

    var thumbnail: String? = null,

    var errorMessage: String? = null

)
