package com.example.eatnow.ui.theme.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.eatnow.ui.theme.components.HeaderText
import com.example.eatnow.ui.theme.components.LoginTextField

val defaultPadding = 16.dp
val itemSpacing = 8.dp

@Composable
fun LoginScreen(navController: NavController){
    // Why dont u use have theme wrapper
Column(
    modifier=Modifier
        .padding(defaultPadding),
    verticalArrangement = Arrangement.Center

){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(defaultPadding),
        horizontalAlignment = CenterHorizontally

    ){
        HeaderText(
            text = "Login",
            modifier=Modifier
                .padding(vertical = defaultPadding)

        )
        LoginTextField(
            value = "",
            labelText = "",
            onValueChange={},
            leadingIcon = Icons.Default.Person,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text="Are you a new user?",
            style=TextStyle(fontSize=20.sp),
            color=Color.Blue
        )
    }
}


}

@Preview(showSystemUi= true)
@Composable
fun PrevLoginScreen(){
    LoginScreen(rememberNavController())
}