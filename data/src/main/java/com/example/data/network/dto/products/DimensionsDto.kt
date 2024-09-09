package com.example.data.network.dto.products

import com.example.domain.model.DimensionsModel
import com.google.gson.annotations.SerializedName

data class DimensionsDto(

    @SerializedName("width")
    var width: Float,

    @SerializedName("height")
    var height: Float,

    @SerializedName("depth")
    var depth: Float

)

fun DimensionsDto.toDimensionsModel(): DimensionsModel {
    return DimensionsModel(
        width = width,
        height = height,
        depth = depth
    )
}