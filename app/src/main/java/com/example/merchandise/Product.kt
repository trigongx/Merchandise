package com.example.merchandise

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class Product(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo (name = "imageId")
    var imageId: String,
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "description")
    var desc: String,
    @ColumnInfo(name = "amount")
    var amount: Int,
    @ColumnInfo(name = "startPrice")
    var start_price: Int,
    @ColumnInfo(name = "endPrice")
    var end_price: Int
)
