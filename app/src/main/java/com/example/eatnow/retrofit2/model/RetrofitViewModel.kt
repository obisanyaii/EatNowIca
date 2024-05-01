package com.example.eatnow.retrofit2.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eatnow.retrofit2.RetrofitClient
import com.example.eatnow.retrofit2.data.Ingredients
import kotlinx.coroutines.launch

class RetrofitViewModel : ViewModel() {
    val harryPotterData = MutableLiveData<Ingredients>()

    init {
        viewModelScope.launch {
            getIngredients()
        }
    }

    private suspend fun getIngredients() {
        harryPotterData.value = RetrofitClient
            .restaurantApiService
            .getIngredientSearch()
    }

}