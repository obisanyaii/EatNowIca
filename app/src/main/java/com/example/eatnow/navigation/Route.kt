package com.example.eatnow.navigation

sealed class Route (val route :  String){
    data object LandingPage : Route(route = "LandingPageActivity")
    data object Login : Route(route = "LoginScreen")
}
