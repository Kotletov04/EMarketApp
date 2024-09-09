package com.example.data.storage.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.DimensionsModel
import com.example.domain.model.MetaModel
import com.example.domain.model.ProductsModel
import com.example.domain.model.ReviewsModel


@Entity(tableName = "ProductsTable")
data class ProductsEntity(

    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo var idProduct: Long?,
    @ColumnInfo var title: String?,
    @ColumnInfo var description: String?,
    @ColumnInfo var category: String?,
    @ColumnInfo var price: Float?,
    @ColumnInfo var discountPercentage: Float?,
    @ColumnInfo var rating: Float?,
    @ColumnInfo var stock: Long?,
    @ColumnInfo var tags: List<String>?,
    @ColumnInfo var brand: String?,
    @ColumnInfo var sku: String?,
    @ColumnInfo var weight: Float?,
    @Embedded var dimensions: DimensionsModel?,
    @ColumnInfo var warrantyInformation: String?,
    @ColumnInfo var shippingInformation: String?,
    @ColumnInfo var availabilityStatus: String?,
    @Embedded var reviews: List<ReviewsModel>?,
    @ColumnInfo var returnPolicy: String?,
    @ColumnInfo var minimumOrderQuantity: Int?,
    @Embedded var meta: MetaModel?,
    @ColumnInfo var images: List<String>?,
    @ColumnInfo var thumbnail: String?


)

fun ProductsEntity.toProductsModel(): ProductsModel {
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
        dimensions = dimensions,
        warrantyInformation = warrantyInformation,
        shippingInformation = shippingInformation,
        availabilityStatus = availabilityStatus,
        reviews = reviews,
        returnPolicy = returnPolicy,
        minimumOrderQuantity = minimumOrderQuantity,
        meta = meta,
        images = images,
        thumbnail = thumbnail


    )
}