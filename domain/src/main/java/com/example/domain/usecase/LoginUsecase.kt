package com.example.domain.usecase

import com.example.domain.common.Resource
import com.example.domain.model.TokenModel
import com.example.domain.repository.TokenRepository
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class LoginUsecase(
    private val tokenRepository: TokenRepository
) {
    operator fun invoke(username: String, password: String): Flow<Resource<TokenModel>> = flow {
        try {
            emit(Resource.Loading())
            val result = tokenRepository.getTokens(username = username, password = password)

            if (result.errorMessage != null) {
                emit(Resource.Error(result.errorMessage))
            } else {
                emit(Resource.Success(result))
                tokenRepository.saveTokens(token = result.token!!, refreshToken = result.refreshToken!!)
            }

        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Неизвестная ошибка"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Ошибка сети"))
        }
    }

}