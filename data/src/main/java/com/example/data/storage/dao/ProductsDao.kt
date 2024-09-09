package com.example.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.storage.entity.ProductsEntity

@Dao
interface ProductsDao {

    @Insert
    suspend fun insertProducts(data: ProductsEntity)

    @Query("SELECT * FROM ProductsTable")
    suspend fun getAllProducts(): List<ProductsEntity>

}