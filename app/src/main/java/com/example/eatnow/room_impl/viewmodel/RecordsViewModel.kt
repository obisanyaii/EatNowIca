package com.example.eatnow.room_impl.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.eatnow.room_impl.ActivityListDatabase
import com.example.eatnow.room_impl.entity.Orders
import com.example.eatnow.room_impl.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class RecordsViewModel(
    application: Application
): AndroidViewModel(application) {

    private val repository: Repository

    init {
        val recordsDao = ActivityListDatabase.getDatabase(application).recordsDao()
        repository = Repository(recordsDao)
    }

    fun addOrder(record: Orders){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addRecord(record)
        }
    }

    fun getAllOrders(email:String) : Flow<List<Orders>>{
        // Trigger the fetch of all items
        return repository.getRecords(email)
    }

}