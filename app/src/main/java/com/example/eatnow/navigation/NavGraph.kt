package com.example.eatnow.navigation

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eatnow.ui.theme.FoodList
import com.example.eatnow.ui.theme.pages.LandingPageActivity
import com.example.eatnow.ui.theme.pages.login.LoginScreen
import com.example.eatnow.ui.theme.pages.login.LoginViewModel
import com.example.eatnow.ui.theme.pages.mainapplication.DetailsPageScreen
import com.example.eatnow.ui.theme.pages.mainapplication.HistoryPageScreen
import com.example.eatnow.ui.theme.pages.mainapplication.HomePageScreen
import com.example.eatnow.ui.theme.pages.mainapplication.SuccessPageScreen
import com.example.eatnow.ui.theme.pages.signup.SignupScreen
import com.google.firebase.auth.FirebaseAuth

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetupNavigationGraph(
    navController: NavHostController
){

    var auth = FirebaseAuth.getInstance()
    var starting = Route.LandingPage.route
    if(null != auth.currentUser){
        starting = Route.HomePageScreen.route
    }

    NavHost(
        navController = navController,
        startDestination = starting
    ){

        composable(
            route = Route.LandingPage.route
        ){
            LandingPageActivity(navController)
        }

        // Add more composable activities below
        composable(
            route = Route.Login.route
        ){
            LoginScreen(navController)
        }

        composable(
            route = Route.Signup.route
        ){
            SignupScreen(navController)
        }

        composable(
            route = Route.HomePageScreen.route
        ){
            HomePageScreen(navController)
        }

        composable(
            route = Route.SuccessPageScreen.route
        ){
            SuccessPageScreen(navController)
        }

        composable(
            route = Route.HistoryPageScreen.route
        ){
            HistoryPageScreen(navController)
        }

        composable(
            route = Route.DetailsPageScreen.route+"/{index}"
        ){
            var index = navController.previousBackStackEntry?.arguments?.getString("index")?.toIntOrNull() ?: 0
            Log.d("TAG arg graph", index.toString())
            var food = FoodList.foodList.getOrNull(index)
            if (food != null) {
                DetailsPageScreen(
                    navController,
                    LoginViewModel(),
                    food
                )
            } else {
                // Handle invalid index or missing food item
            }
        }

    }
}