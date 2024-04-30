package com.example.eatnow.room_impl.repository

import com.example.eatnow.room_impl.OrdersDao
import com.example.eatnow.room_impl.entity.Orders
import kotlinx.coroutines.flow.Flow

class Repository (
    private val ordersDao: OrdersDao,
){

    suspend fun addRecord(record: Orders){
        ordersDao.addOrder(record)
    }

    fun getRecords(email: String): Flow<List<Orders>> {
        return ordersDao.getAllOrders(email)
    }

}