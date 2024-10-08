package com.example.testing.di

import com.example.domain.repository.ProductsRepository
import com.example.domain.repository.TokenRepository
import com.example.domain.usecase.LoginUsecase
import com.example.domain.usecase.ProductsUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Singleton
    @Provides
    fun provideLoginUsecase(tokenRepository: TokenRepository): LoginUsecase {
        return LoginUsecase(tokenRepository = tokenRepository)
    }

    @Provides
    @Singleton
    fun provideProductUsecase(productsRepository: ProductsRepository): ProductsUsecase {
        return ProductsUsecase(productsRepository = productsRepository)
    }
}