package com.example.data.network.dto.token

import android.media.session.MediaSession.Token
import com.example.domain.model.TokenModel
import com.google.gson.annotations.SerializedName

data class TokenDto(

    @SerializedName("id")
    var id: Long,

    @SerializedName("username")
    var username: String,

    @SerializedName("email")
    var email: String,

    @SerializedName("firstName")
    var firstName: String,

    @SerializedName("lastName")
    var lastName: String,

    @SerializedName("gender")
    var gender: String,

    @SerializedName("image")
    var image: String,

    @SerializedName("token")
    var token: String,

    @SerializedName("refreshToken")
    var refreshToken: String

)

fun TokenDto.toTokenModel(): TokenModel {
    return TokenModel(
        id = id,
        username = username,
        email = email,
        firstName = firstName,
        lastName = lastName,
        gender = gender,
        image = image,
        token = token,
        refreshToken = refreshToken
    )
}
