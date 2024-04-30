package com.example.eatnow.navigation

sealed class Route (val route :  String){
    data object LandingPage : Route(route = "LandingPageActivity")
    data object Login : Route(route = "LoginScreen")
    data object Signup : Route(route = "SignupScreen")
    data object HomePageScreen : Route(route = "HomePageScreen")
    data object SuccessPageScreen : Route(route = "SuccessPageScreen")
    data object DetailsPageScreen : Route(route = "DetailsPageScreen/{index}")
}
