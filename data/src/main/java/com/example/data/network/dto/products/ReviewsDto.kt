package com.example.data.network.dto.products

import com.google.gson.annotations.SerializedName

data class ReviewsDto(

    @SerializedName("rating")
    var rating: Int,

    @SerializedName("comment")
    var comment: String,

    @SerializedName("date")
    var date: String,

    @SerializedName("reviewerName")
    var reviewerName: String,

    @SerializedName("reviewerEmail")
    var reviewerEmail: String

)
