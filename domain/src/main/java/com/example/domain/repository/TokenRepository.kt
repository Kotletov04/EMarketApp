package com.example.domain.repository

import com.example.domain.model.TokenModel

interface TokenRepository {

    suspend fun saveTokens(token: String, refreshToken: String)

    suspend fun getTokens(username: String, password: String): TokenModel

    suspend fun getTokenInShared(): String

    suspend fun getRefreshTokenInShared(): String
}