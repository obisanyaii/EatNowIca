package com.example.eatnow.room_impl.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class Orders(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    val email: String,
    val price: String,
    val foodName : String,
    val foodDescription: String
)