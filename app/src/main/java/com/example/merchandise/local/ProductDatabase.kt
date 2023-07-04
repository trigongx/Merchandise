package com.example.merchandise.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.merchandise.Product
import com.example.merchandise.local.entity.SellHistory
import com.example.merchandise.local.entity.SellHistoryDao

@Database(entities = [Product::class,SellHistory::class], version = 3)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun getDao():ProductDao
    abstract fun getSellHistoryDao(): SellHistoryDao
}