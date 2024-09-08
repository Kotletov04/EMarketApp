package com.example.domain.model

data class TokenModel(

    var id: Long? = null,

    var username: String? = null,

    var email: String? = null,

    var firstName: String? = null,

    var lastName: String? = null,

    var gender: String? = null,

    var image: String? = null,

    var token: String? = null,

    var refreshToken: String? = null,

    var errorMessage: String? = null

)
