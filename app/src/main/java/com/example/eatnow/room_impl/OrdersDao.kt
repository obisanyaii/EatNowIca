package com.example.eatnow.room_impl

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.eatnow.room_impl.entity.Orders
import kotlinx.coroutines.flow.Flow

@Dao
interface OrdersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addOrder(records: Orders)

    @Query("SELECT * FROM orders WHERE email=:email ORDER BY id DESC")
    fun getAllOrders(email: String): Flow<List<Orders>>
}
