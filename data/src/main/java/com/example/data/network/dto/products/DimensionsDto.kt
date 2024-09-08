package com.example.data.network.dto.products

import com.google.gson.annotations.SerializedName

data class DimensionsDto(

    @SerializedName("width")
    var width: Float,

    @SerializedName("height")
    var height: Float,

    @SerializedName("depth")
    var depth: Float

)
