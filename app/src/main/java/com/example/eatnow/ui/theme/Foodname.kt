package com.example.eatnow.ui.theme

import androidx.annotation.DrawableRes
import com.example.eatnow.R

data class FoodName(
    @DrawableRes val imageResId: Int,
    val name: String,
    val description: String,
    val price : String
)

object FoodList {
    val foodList = listOf(
        FoodName(R.drawable.naijajollof, "Naija Jollof", "Original Nigerian Jollof rice", "35.00"),
        FoodName(R.drawable.eforiro, "Spicy Vegetable", "Spiced green vegetable", "12.13"),
        FoodName(R.drawable.egusisoup, "Spicy Melon", "Spiced and melon soup","12.13"),
        FoodName(R.drawable.frenchfries, "French Fries", "Sliced and fried potatoes","12.13"),
        FoodName(R.drawable.friedchicken, "Fried Chicken", "Roasted and spiced chicken","12.13"),
        FoodName(R.drawable.ofadariceandstew, "Ofada Rice", "Locally grown rice","12.13"),
        FoodName(R.drawable.poundedyam, "Pounded Yam", "Pounded yam","12.13")
    )
}
