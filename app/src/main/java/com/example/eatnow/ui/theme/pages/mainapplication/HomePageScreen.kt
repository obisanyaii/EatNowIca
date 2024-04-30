package com.example.eatnow.ui.theme.pages.mainapplication

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.eatnow.R
import com.example.eatnow.navigation.Route
import com.example.eatnow.retrofit2.model.RetrofitViewModel
import com.example.eatnow.ui.theme.EatNowTheme
import com.example.eatnow.ui.theme.FoodList
import com.example.eatnow.ui.theme.pages.login.LoginViewModel

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
                    .background(Color.White)
                    .verticalScroll(rememberScrollState())
                    .padding(20.dp, 0.dp, 20.dp, 0.dp)
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
                                        .weight(2f)
                                        .clickable {
                                            navController.navigate(Route.HistoryPageScreen.route)
                                        },
                                    horizontalAlignment = Alignment.End
                                ){
                                    Icon (
                                        imageVector = Icons.Filled.ShoppingCart,
                                        contentDescription = "History",
                                        tint = Color.Black
                                    )
                                    Text(text = "History", color = Color.Black)
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
                                        contentDescription = "Log out",
                                        tint = Color.Black
                                    )
                                    Text(text = "Logout", color = Color.Black)
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
                        style = androidx.compose.ui.text.TextStyle(fontSize = 29.sp),
                        color = Color.Black
                    )

                    Text(
                        text = "We deliver what you need to eat ..",
                        style = androidx.compose.ui.text.TextStyle(fontSize = 16.sp),
                        color = Color.Black
                    )

                    Spacer(
                        modifier = Modifier
                            .height(4.dp)
                            .width(3.dp)
                    )

                    Column (
                        modifier = Modifier
                            .padding(start = 0.dp, 40.dp),
                        verticalArrangement = Arrangement.Top
                    ) {
                        Text(
                            text = "Cooking recipes",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(80.dp, 0.dp),
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(15.dp))

                        ScrollableNewsRow()
                    }

                    Divider(
                        color = Color.Black,
                        thickness = 2.dp,
                        modifier = Modifier
                            .padding(0.dp, 20.dp)
                    )

                    val foods = FoodList.foodList
                    for (food in foods) {
                        Column (
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(0.dp, 0.dp, 0.dp, 15.dp)
                                .clickable {
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
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                    Text(
                                        text = food.description +
                                                "\n\nPrice: " +
                                                "\n£" + food.price,
                                        color = Color.Black
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

@Composable
fun ScrollableNewsRow(retrofitViewModel: RetrofitViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val data by retrofitViewModel.harryPotterData.observeAsState()

    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState()),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = Icons.Filled.KeyboardArrowLeft,
            contentDescription = "Scroll ingredients search to the left",
            modifier = Modifier
                .size(80.dp)
                .padding(0.dp, 0.dp, 40.dp, 0.dp)
                .then(Modifier.offset((3).dp, 0.dp)),
            tint = Color.Black
        )

        val context = LocalContext.current
        data?.results?.forEach { ingredient ->
//            ElevatedCard (
//                modifier = Modifier
//                    .height(40.dp)
//                    .width(180.dp)
//                    .padding(0.dp, 0.dp, 10.dp)
//                    .clickable {
//                        val uri = Uri.parse("https://google.com/search?q=" + ingredient.name)
//                        val intent = Intent(Intent.ACTION_VIEW, uri)
//
//                        context.startActivity(intent)
//                    }
//            ){
//                Text(
//                    text = ingredient.name,
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.padding(10.dp)
//                )
//            }
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