package com.example.eatnow.ui.theme.pages
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eatnow.Food
import com.example.eatnow.R
import com.example.eatnow.foodList

@Composable
fun ShowFoodList(foodList: List<Food>) {
    LazyColumn {
        items(foodList) { food ->
            EatNowFoodCard(food = food, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun EatNowFoodCard(food: Food, modifier: Modifier = Modifier) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier.fillMaxWidth().padding(8.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Display the image for the food
            Image(
                painter = painterResource(id = food.imgResources),
                contentDescription = food.title,
                modifier = Modifier.fillMaxWidth().height(130.dp)
            )
            Column(modifier = Modifier.padding(8.dp)) {
                // Display food description
                Text(text = food.descAmountCharge)
            }
        }
    }
}

@Composable
fun MyFoodScreen() {
    ShowFoodList(foodList = foodList)
}

@Preview(showBackground = true, showSystemUi= true)
@Composable
fun EatNowFoodCardPreview() {
    val sampleFood = Food(
        imgResources = R.drawable.friedchicken,
        title = "Fried Chicken",
        descAmountCharge = "Price: £5.00",
        price = 5.00
    )
    EatNowFoodCard(food = sampleFood, modifier = Modifier.padding(16.dp))
}