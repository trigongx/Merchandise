package com.example.merchandise.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.merchandise.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert
    fun createProduct(product: Product)

    @Query("SELECT * FROM product")
    fun getAllProduct(): List<Product>

    @Query("SELECT * FROM product WHERE id=:productId")
    fun getProductId(productId: Int): Product?

    @Delete
    fun deleteProduct(product: Product)

    @Update
    fun updateProduct(product: Product)
}