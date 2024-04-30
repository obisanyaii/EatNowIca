package com.example.eatnow.retrofit2.data

data class Ingredients(
    val number: Int,
    val offset: Int,
    val results: List<Result>,
    val totalResults: Int
)