package com.example.eatnow.ui.theme.pages.mainapplication

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
import com.example.eatnow.ui.theme.pages.signup.SignupViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomePageScreen(
    navController: NavController,
    viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
){
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
                        .verticalScroll(rememberScrollState())
                ) {
                    // Body
                    Text(
                        text = "Welcome to \nEatNow",
                        fontWeight = FontWeight.Bold,
                        style = androidx.compose.ui.text.TextStyle(fontSize = 29.sp)
                    )

                    Text(
                        text = "We deliver what you need to eat ..",
                        style = androidx.compose.ui.text.TextStyle(fontSize = 16.sp)
                    )

                    Spacer(
                        modifier = Modifier
                            .height(4.dp)
                            .width(3.dp)
                    )

                    Divider(
                        color = Color.Black,
                        thickness = 2.dp,
                        modifier = Modifier
                            .padding(0.dp, 40.dp)
                    )

                    val foods = FoodList.foodList

                    for (food in foods) {
                        Column (
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(0.dp, 0.dp, 0.dp, 15.dp)
                                .clickable {
//                                    Log.d("TAG args navigate", "${Route.DetailsPageScreen.route}/${foods.indexOf(food)}")
//                                    Log.d("TAG args navigate", "${Route.DetailsPageScreen.route}/${foods.indexOf(food)}")
//                                    Log.d("TAG args index value", foods.indexOf(food).toString())
                                    navController.navigate(
                                        route = "${Route.DetailsPageScreen.route}/?index=${foods.indexOf(food)}"
                                    )
                                }
                        ) {
                            Row {
                                Column{
                                    Icon(
                                        imageVector = Icons.Filled.Menu,
                                        contentDescription = "Item icon"
                                    )
                                }
                                Column (
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Top,
                                    modifier = Modifier
                                        .weight(5f)
                                ){
                                    Image(
                                        painter = painterResource(id = food.imageResId),
                                        contentDescription = "Food image",
                                        modifier = Modifier
                                            .size(200.dp)
                                            .fillMaxWidth(),
                                        contentScale = ContentScale.FillHeight
                                    )
                                }
                                Column (
                                    modifier = Modifier.weight(2f),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ){
                                    Text(
                                        text = food.name,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = food.description +
                                                "\n\nPrice: " +
                                                "\n£" + food.price
                                    )
                                }
                            }
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
fun PreviewHomePageScreen(){
    HomePageScreen(
        rememberNavController()
    )
}