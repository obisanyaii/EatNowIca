package com.example.eatnow.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.eatnow.LandingPageActivity
import com.example.eatnow.ui.theme.login.LoginScreen

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
    }
}