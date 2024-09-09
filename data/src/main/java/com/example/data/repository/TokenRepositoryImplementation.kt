package com.example.data.repository

import android.content.Context
import android.media.session.MediaSession.Token
import com.example.data.network.dto.token.TokenDto
import com.example.data.network.dto.token.toTokenModel
import com.example.data.network.requests.TokenRequest
import com.example.domain.model.AuthModel
import com.example.domain.model.TokenModel
import com.example.domain.repository.TokenRepository
import retrofit2.Retrofit
import javax.inject.Inject

class TokenRepositoryImplementation @Inject constructor(private val context: Context, private val retrofit: Retrofit): TokenRepository {

    private val authRequest: TokenRequest by lazy {
        retrofit.create(TokenRequest::class.java)
    }

    private val SHARED_PREFS = "shared_prefs_token"
    private val KEY_TOKEN = "token"
    private val KEY_REFRESH_TOKEN = "refresh_token"
    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)


    override suspend fun saveTokens(token: String, refreshToken: String) {
        sharedPreferences.edit().putString(KEY_TOKEN, token).apply()
        sharedPreferences.edit().putString(KEY_REFRESH_TOKEN, refreshToken).apply()
    }

    override suspend fun getTokens(username: String, password: String): TokenModel {
        val response = authRequest.TokenRequest(AuthModel(username, password))
        return if (response.isSuccessful) {
            response.body()!!.toTokenModel()
        } else {
            TokenModel(errorMessage = response.message())
        }
    }

    override suspend fun getTokenInShared(): String {
        return sharedPreferences.getString(KEY_TOKEN, "")!!
        }

    override suspend fun getRefreshTokenInShared(): String {
        return sharedPreferences.getString(KEY_REFRESH_TOKEN, "")!!
    }
}

