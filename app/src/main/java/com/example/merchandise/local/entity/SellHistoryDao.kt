package com.example.merchandise.local.entity

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.merchandise.Product

@Dao
interface SellHistoryDao {

    @Insert
    fun createSellHistory(sellHistory: SellHistory)

    @Query("SELECT * FROM sellHistory")
    fun getAllSellHistory(): List<SellHistory>

    @Delete
    fun deleteSellHistory(sellHistory: SellHistory)

    @Update
    fun updateSellHistory(sellHistory: SellHistory)

}