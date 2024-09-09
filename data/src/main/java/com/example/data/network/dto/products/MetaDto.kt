package com.example.data.network.dto.products

import com.example.domain.model.MetaModel
import com.google.gson.annotations.SerializedName

data class MetaDto(

    @SerializedName("createdAt")
    var createdAt: String,

    @SerializedName("updatedAt")
    var updatedAt: String,

    @SerializedName("barcode")
    var barcode: String,

    @SerializedName("qrCode")
    var qrCode: String

)

fun MetaDto.toMetaModel(): MetaModel {
    return MetaModel(
        createdAt = createdAt,
        updatedAt = updatedAt,
        barcode = barcode,
        qrCode = qrCode

    )
}