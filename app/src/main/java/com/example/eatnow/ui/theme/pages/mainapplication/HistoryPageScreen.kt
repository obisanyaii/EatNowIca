package com.example.eatnow.ui.theme.pages.mainapplication

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.eatnow.R
import com.example.eatnow.navigation.Route
import com.example.eatnow.room_impl.entity.Orders
import com.example.eatnow.room_impl.viewmodel.RecordsViewModel
import com.example.eatnow.ui.theme.EatNowTheme
import com.example.eatnow.ui.theme.pages.login.LoginViewModel
import com.google.firebase.auth.FirebaseAuth

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HistoryPageScreen(
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
                                .clickable {
                                    navController.navigate(Route.HomePageScreen.route)
                                }
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
                    modifier= Modifier
                        .weight(6f)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ){

                    Text(
                        text = "Order history",
                        style = TextStyle(fontSize = 23.sp),
                        color = Color.Black
                    )

                    Divider(
                        color = Color.Black,
                        thickness = 2.dp,
                        modifier = Modifier
                            .padding(0.dp, 20.dp)
                    )

                    // Table goes below
                    OrderHistoryTable()

                }
            }


        }
    }
}

@Composable
fun OrderHistoryTable(
    recordsViewModel: RecordsViewModel = viewModel()
) {

    Column (
        modifier = Modifier.fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {

        val auth = FirebaseAuth.getInstance()
        val user = auth.currentUser?.email

        // Display list of items
        val recordsState by recordsViewModel.getAllOrders(user!!)
            .collectAsState(initial = emptyList())

        val recordsSize = remember(recordsState) {
            derivedStateOf {
                recordsState.size
            }
        }.value

        if (recordsState.isEmpty() || recordsSize < 1) {
            Image(
                painter = painterResource(R.drawable.empty),
                contentDescription = "Empty activity list",
                modifier = Modifier
                    .size(150.dp)
                    .fillMaxHeight()
            )
            Text(
                text = "No Activity",
                color = Color.Black
            )
        } else {
            // Table header
            HeaderTable()

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                var pos = 0

                recordsState.forEach { order ->
                    pos++

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        // # - id
                        Box(
                            modifier = Modifier
                                .width(40.dp)
                                .height(90.dp)
                                .padding(2.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Text(
                                text = pos.toString(),
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        }

                        // email
                        Box(
                            modifier = Modifier
                                .width(140.dp)
                                .height(90.dp)
                                .padding(2.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Text(
                                text = order.email.toString(),
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        }

                        // Food name
                        Box(
                            modifier = Modifier
                                .width(120.dp)
                                .height(90.dp)
                                .padding(2.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Text(
                                text = order.foodName.toString() + "\n" + order.foodDescription.toString(),
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        }

                        // price
                        Box(
                            modifier = Modifier
                                .width(60.dp)
                                .height(90.dp)
                                .padding(2.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Text(
                                text = order.price.toString(),
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        }

                        // status
                        Box(
                            modifier = Modifier
                                .width(90.dp)
                                .height(90.dp)
                                .padding(2.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Text(
                                text = "DELIVERED",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun HeaderTable() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // # - id
            Box(
                modifier = Modifier
                    .width(40.dp)
                    .height(50.dp)
                    .padding(2.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = "#",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }

            // email
            Box(
                modifier = Modifier
                    .width(140.dp)
                    .height(50.dp)
                    .padding(2.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = "C. Email",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }

            // Food name
            Box(
                modifier = Modifier
                    .width(120.dp)
                    .height(50.dp)
                    .padding(2.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = "Food",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }

            // price
            Box(
                modifier = Modifier
                    .width(60.dp)
                    .height(50.dp)
                    .padding(2.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = "Price",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }

            // status
            Box(
                modifier = Modifier
                    .width(90.dp)
                    .height(50.dp)
                    .padding(2.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = "Status",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview(showBackground = true)
fun PreviewHistoryPageScreen(){
    HistoryPageScreen(
        rememberNavController()
    )
}