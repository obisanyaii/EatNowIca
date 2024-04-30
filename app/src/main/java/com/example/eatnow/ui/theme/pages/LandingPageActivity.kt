package com.example.eatnow.ui.theme.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.eatnow.R
import com.example.eatnow.navigation.Route
import com.example.eatnow.ui.theme.EatNowTheme

@Composable
fun LandingPageActivity(navController: NavController){
    EatNowTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {

                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .size(90.dp),
                        painter = painterResource(id = R.drawable.catering_logo),
                        contentDescription = "Logo"
                    )

                    Text(
                        text = "EatNow",
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(fontSize = 26.sp),
                        color = Color.Black
                    )
                }

                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(3.4f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(60.dp),
                        painter = painterResource(id = R.drawable.chef),
                        contentDescription = "Chef"
                    )
                }

                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Button(
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            navController.navigate(Route.Login.route)
                        },
                        shape = RectangleShape
                    ) {
                        Text(
                            text = "Get Started",
                            style = TextStyle(fontSize = 20.sp),
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LandingPageActivityPreview(){
    LandingPageActivity(rememberNavController())
}