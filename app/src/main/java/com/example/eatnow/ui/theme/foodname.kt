package com.example.eatnow.ui.theme

import androidx.annotation.DrawableRes
import com.example.eatnow.R

data class FoodName(
    @DrawableRes val imgResource: Int,
    val title: String,
    val desc: String
)

val foodList= listOf(
    FoodName(R.drawable.naijajollof, "Naija Jollof", "original Nigerian Jollof rice" ),
    FoodName(R.drawable.eforiro, "spicy vegetable", "spiced green vegetable"),
    FoodName(R.drawable.egusisoup, "spicy melon", "spiced and melon soup "),
    FoodName(R.drawable.frenchfries, "French fries", "Sliced and fried potatoes "),
    FoodName(R.drawable.friedchicken, "Fried Chicken", "roasted and spiced chicken"),
    FoodName(R.drawable.ofadariceandstew, "Ofada rice", "Locally grown rice"),
    FoodName(R.drawable.poundedyam, "Pounded yam", "Pounded yam")
)