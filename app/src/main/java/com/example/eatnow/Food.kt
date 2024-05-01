package com.example.eatnow

import androidx.annotation.DrawableRes

data class Food(
    @DrawableRes val imgResources: Int,
    val title: String,
    val descAmountCharge:String,
    val price: Double
)

val foodList = listOf(
    Food(R.drawable.friedchicken, "Fried Chicken", "Price:£5.00", 5.00   ),
    Food(R.drawable.frenchfries, "French fries", "Price:£3.00", 3.00),
    Food(R.drawable.naijajollof, "Naija jollof", "Price:£2.50", 2.50),
    Food(R.drawable.ofadariceandstew, "Ofada Rice and stew", "Price:£4.50", 4.58),
    Food(R.drawable.eforiro, "Efo riro", "Price:£6.50", 6.50),
    Food(R.drawable.egusisoup, "Egusi soup", "Price:£4.00", 4.00),
    Food(R.drawable.poundedyam, "Pounded yam", "Price:£3.45", 3.45)

)

