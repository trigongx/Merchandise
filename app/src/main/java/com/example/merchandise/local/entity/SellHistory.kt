package com.example.merchandise.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.merchandise.Product

@Entity (tableName = "sellHistory",
    foreignKeys = [ForeignKey(
        entity = Product::class,
        childColumns = ["productID"],
        parentColumns = ["id"])])
data class SellHistory(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "productID")
    var productId: Int,
    @ColumnInfo(name = "amount")
    var amount: Int,
    @ColumnInfo(name = "price")
    var price: Int,
    @ColumnInfo(name = "sellDate")
    var date: String
)
