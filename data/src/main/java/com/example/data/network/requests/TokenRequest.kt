package com.example.data.network.requests

import com.example.data.network.dto.token.TokenDto
import com.example.domain.model.AuthModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TokenRequest {

    @POST("auth/login")
    suspend fun TokenRequest(@Body authInfo: AuthModel): Response<TokenDto>
}