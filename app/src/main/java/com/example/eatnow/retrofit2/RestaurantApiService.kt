package com.example.eatnow.retrofit2

import com.example.eatnow.retrofit2.data.Ingredients
import retrofit2.http.GET

interface RestaurantApiService {
    @GET("search?query=banana&number=200&sort=calories&sortDirection=desc")
    suspend fun getIngredientSearch() : Ingredients
}