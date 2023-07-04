package com.example.merchandise

import android.app.Application
import androidx.room.Room
import com.example.merchandise.local.ProductDatabase

class App: Application() {
    private lateinit var database: ProductDatabase
    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, ProductDatabase::class.java, "Merchandise")
        .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    fun getDatabase() : ProductDatabase {
        return database
    }
    companion object {
        var instance: App? = null
    }
}