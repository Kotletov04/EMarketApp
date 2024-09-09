package com.example.data.network.dto.products

import com.example.domain.model.ReviewsModel
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

fun ReviewsDto.toReviewsModel(): ReviewsModel {
    return ReviewsModel(
        rating = rating,
        comment = comment,
        date = date,
        reviewerName = reviewerName,
        reviewerEmail = reviewerEmail
    )
}
