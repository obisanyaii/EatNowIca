package com.example.eatnow.ui.theme.pages.mainapplication

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.eatnow.R
import com.example.eatnow.navigation.Route
import com.example.eatnow.ui.theme.EatNowTheme
import com.example.eatnow.ui.theme.FoodList
import com.example.eatnow.ui.theme.FoodName
import com.example.eatnow.ui.theme.pages.login.LoginViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DetailsPageScreen(
    navController: NavController,
    viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    initialFood : FoodName
){
    var food by remember { mutableStateOf(initialFood) }
    Log.d("TAG args", food.name)
    EatNowTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = androidx.compose.ui.Modifier
                .fillMaxSize()
        ) {

            Column(
                Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(20.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Column (
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.catering_logo),
                                contentDescription = "Logo",
                                modifier = Modifier.size(100.dp)
                            )
                        }
                        Column (
                            modifier = Modifier
                                .weight(2f),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
                            Row{
                                Column (
                                    modifier = Modifier
                                        .weight(2f),
                                    horizontalAlignment = Alignment.End
                                ){
                                    Icon (
                                        imageVector = Icons.Filled.ShoppingCart,
                                        contentDescription = "History"
                                    )
                                    Text(text = "History")
                                }

                                Column (
                                    modifier = Modifier
                                        .weight(1f)
                                        .clickable {
                                            viewModel.signOut()
                                            navController.navigate(Route.Login.route)
                                        },
                                    horizontalAlignment = Alignment.End
                                ){
                                    Icon (
                                        imageVector = Icons.Filled.ExitToApp,
                                        contentDescription = "Log out"
                                    )
                                    Text(text = "Logout")
                                }
                            }

                        }
                    }
                }

                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(7f)
                        .padding(0.dp, 40.dp)
                ) {


                    // Body

                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(3f)
                        ) {
                            Text(
                                text = food.name,
                                fontWeight = FontWeight.Bold,
                                style = androidx.compose.ui.text.TextStyle(fontSize = 40.sp)
                            )
                        }
                        Column (
                            modifier = Modifier
                                .weight(1f)
                                .clickable {
                                    navController.navigate(Route.HomePageScreen.route)
                                },
                            horizontalAlignment = Alignment.End
                        ){
                            Text(
                                text = "Go back",
                                color = Color.Red
                            )
                            Icon (
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Return back",
                                modifier = Modifier.size(30.dp),
                                tint = Color.Red
                            )
                        }
                    }







                    // Image
                    Spacer(
                        modifier = Modifier
                            .height(30.dp)
                            .width(3.dp)
                    )
                    Image(
                        painter = painterResource(id = food.imageResId),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(200.dp)
                    )

                    Spacer(
                        modifier = Modifier
                            .height(40.dp)
                            .width(3.dp)
                    )

                    Text(text = food.description)

                    // Details
                    Text(
                        text = "Details",
                        fontWeight = FontWeight.Bold,
                        style = androidx.compose.ui.text.TextStyle(fontSize = 30.sp)
                    )

                    Spacer(
                        modifier = Modifier
                            .height(4.dp)
                            .width(3.dp)
                            .border(2.dp, Color.Red)
                    )

                    Text(
                        text = "Price: £${food.price}",
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 20.sp
                        )
                    )

                    var quantity by remember { mutableIntStateOf(1) }
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = quantity.toString(),
                        onValueChange = { newQuantity ->
                            quantity = newQuantity.toIntOrNull() ?: 1
                        },
                        label = {
                            Text(text = "Quantity")
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Create,
                                contentDescription = "icon"
                            )
                        }
                    )




                    Spacer(
                        modifier = Modifier
                            .height(30.dp)
                            .width(3.dp)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        // Button
                        Button(
                            colors = ButtonDefaults.buttonColors(Color.Black),
                            onClick = {
                                navController.navigate(Route.SuccessPageScreen.route)
                            },
                            modifier= Modifier
                                .fillMaxWidth(),
                            shape = RectangleShape
                        ) {
                            Text(
                                text = "Place order",
                                fontWeight = FontWeight.Bold
                            )
                        }

                    }


                }




            }


        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview(showBackground = true)
fun PreviewDetailsPageScreen(){
    DetailsPageScreen(
        rememberNavController(),
        LoginViewModel(),
        initialFood = FoodName(
            R.drawable.friedchicken,
            name = "Fried Chicken",
            description = "Food for thought",
            price = "5.00"
        )
    )
}