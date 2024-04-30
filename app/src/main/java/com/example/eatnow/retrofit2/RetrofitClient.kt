package com.example.eatnow.retrofit2

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.spoonacular.com/food/ingredients/"
    private const val API_KEY = "b7a8e089409740c4b42cc2d75175ef17" // Replace with your actual API key
    private val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    // Define the interceptor to add x-api-key header
    private val apiKeyInterceptor = Interceptor { chain ->
        val originalRequest = chain.request()
        val newRequest = originalRequest.newBuilder()
            .header("x-api-key", API_KEY)
            .build()
        chain.proceed(newRequest)
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(apiKeyInterceptor) // Add the interceptor to attach API key header
        .build()

    val restaurantApiService: RestaurantApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(RestaurantApiService::class.java)
    }
}