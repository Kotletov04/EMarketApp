package com.example.testing.di

import android.content.Context
import androidx.room.Room
import com.example.data.repository.TokenRepositoryImplementation
import com.example.data.storage.AppDatabase
import com.example.domain.repository.TokenRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    private val BASE_URL = "https://dummyjson.com/"

    @Singleton
    @Provides
    fun provideRetrofitApi(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun provideTokenRepository(@ApplicationContext context: Context, retrofit: Retrofit): TokenRepository {
        return TokenRepositoryImplementation(context = context, retrofit = retrofit)
    }


    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context = context,
        klass = AppDatabase::class.java,
        name = "MarketDatabase.db"
    )
}