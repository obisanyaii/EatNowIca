package com.example.eatnow.ui.theme.pages.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.eatnow.R
import com.example.eatnow.navigation.Route


@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    var username by remember{
        mutableStateOf("")
    }

    var password by remember{
        mutableStateOf("")
    }


    val localContest = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
    ) {
        Column (
            Modifier
                .fillMaxSize()
                .padding(44.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
        ) {
            LoginHeader()

            LoginFields(username, password,
                onUsernameChange = {
                    username=it
                }, onPasswordChange = {
                    password=it
                },onForgotPasswordClick = {

                })

            if(viewModel.isLoading) {
                CircularProgressIndicator()
            } else {
                LoginFooter(
                    navController,
                    onSignInClick = {
                        viewModel.signInWithEmailAndPassword(username,password) {
                            navController.navigate(Route.HomePageScreen.route)
                        }
                    },
                    onSignUpClick = {}

                )
            }

            if(viewModel.loginErr.isNotEmpty()) {
                Toast.makeText(localContest, viewModel.loginErr, Toast.LENGTH_SHORT).show()
            }


        }

    }
}

@Composable
fun LoginHeader() {
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

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(10.dp)
    )    {
        Text(
            text = "Welcome to EatNow",
            fontSize=22.sp,
            fontWeight = FontWeight.Bold
        )
        Text(text = "Sign in below to continue...",
            fontSize = 18.sp,
            fontWeight=FontWeight.SemiBold)

    }
}


@Composable
fun LoginFields(username: String, password: String,
                onUsernameChange: (String) -> Unit,
                onPasswordChange: (String) -> Unit,
                onForgotPasswordClick: () -> Unit
){
    Column{
        DemoField(value = username,
            label ="Email",
            placeholder = "Enter your Email Address",
            onValueChange = onUsernameChange,
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = "Email")
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        DemoField(value = password,
            label = "Password",
            placeholder = "Enter your password",
            onValueChange =onPasswordChange,
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription ="Password" )
            }
        )
//        TextButton(onClick = onForgotPasswordClick, modifier=Modifier.align(Alignment.End)) {
//            Text(text = "Forgot password?")
//        }
    }

}

@Composable
fun LoginFooter(
    navController: NavController,
    onSignInClick: () -> Unit,
    onSignUpClick: () -> Unit

){

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            colors = ButtonDefaults.buttonColors(Color.Black),
            onClick = onSignInClick,
            modifier= Modifier
                .fillMaxWidth(),
            shape = RectangleShape
        ) {
            Text(text = "Sign In", color = Color.White)
        }
        TextButton(onClick = onSignUpClick) {
            Text(
                text = "New user? click here to register",
                modifier = Modifier.clickable {
                    navController.navigate(Route.Signup.route)
                },
                color = Color.Black
            )
        }
    }


}

@Composable
fun DemoField(value: String,
              label: String,
              placeholder: String,
              visualTransformation: VisualTransformation=VisualTransformation.None,
              keyboardOptions: KeyboardOptions=KeyboardOptions.Default,
              leadingIcon: @Composable (() -> Unit)?=null,
              trailingIcon: @Composable (() -> Unit)?=null,

              onValueChange: (String) -> Unit
){
    OutlinedTextField(
        value=value,
        onValueChange = onValueChange,
        label={
            Text(text=label)
        },
        placeholder={
            Text(text=placeholder)
        },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White

        )
    )
}

@Preview(showBackground = true, showSystemUi= true)
@Composable
fun PrevLoginScreen(){
    LoginScreen(
        rememberNavController(),
        androidx.lifecycle.viewmodel.compose.viewModel()
    )
}