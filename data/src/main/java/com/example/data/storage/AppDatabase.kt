package com.example.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.storage.dao.ProductsDao
import com.example.data.storage.entity.ProductsEntity


@Database(
    entities = [
        ProductsEntity::class
    ],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getProductsDao(): ProductsDao

}