package com.example.eatnow.ui.theme.pages.mainapplication

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.eatnow.R
import com.example.eatnow.navigation.Route
import com.example.eatnow.ui.theme.EatNowTheme
import com.example.eatnow.ui.theme.pages.login.LoginViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SuccessPageScreen(
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
                        .weight(6f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){

                    Image(
                        painter = painterResource(id = R.drawable.success_image),
                        contentDescription = "Success image",
                        modifier = Modifier
                            .size(300.dp)
                    )


                    Spacer(
                        modifier = Modifier
                            .height(20.dp)
                            .width(3.dp)
                    )

                    Text(
                        text = "Order placed successfully",
                        color = Color.Black
                    )

                    Spacer(
                        modifier = Modifier
                            .height(20.dp)
                            .width(3.dp)
                    )

                    Text(
                        modifier = Modifier
                            .clickable {
                                navController.navigate(Route.HomePageScreen.route)
                            },
                        text = "Return back home",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }




            }


        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview(showBackground = true)
fun PreviewSuccessPageScreen(){
    SuccessPageScreen(
        rememberNavController()
    )
}