package com.example.domain.usecase

import com.example.domain.common.Resource
import com.example.domain.model.ProductsModel
import com.example.domain.repository.ProductsRepository
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException


class ProductsUsecase(private val productsRepository: ProductsRepository) {

    operator fun invoke(): Flow<Resource<ProductsModel>> = flow {
        try {
            emit(Resource.Loading())
            val request = productsRepository.getAllProductsFromApi()
            if (request[0].errorMessage != null) {
                emit(Resource.Error(request[0].errorMessage))

            } else {
                request.forEach { product ->
                    emit(Resource.Success(data = product))
                    productsRepository.saveProducts(products = product)
                }
            }
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Неизвестная ошибка"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Ошибка сети"))
        }
    }
}

