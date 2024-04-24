package com.example.eatnow.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.eatnow.ui.theme.pages.LandingPageActivity
import com.example.eatnow.ui.theme.pages.login.LoginScreen
import com.example.eatnow.ui.theme.pages.mainapplication.DetailsPageScreen
import com.example.eatnow.ui.theme.pages.mainapplication.HomePageScreen
import com.example.eatnow.ui.theme.pages.mainapplication.SuccessPageScreen
import com.example.eatnow.ui.theme.pages.signup.SignupScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetupNavigationGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Route.LandingPage.route
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
            route = Route.DetailsPageScreen.route
        ){
            DetailsPageScreen(navController)
        }
    }
}