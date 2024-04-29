package com.example.eatnow.ui.theme.pages.signup

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


@Composable
fun SignupScreen(
    navController: NavController
) {

    var firstname by remember{
        mutableStateOf("")
    }

    var lastname by remember{
        mutableStateOf("")
    }

    var email by remember{
        mutableStateOf("")
    }

    var phonenumber by remember{
        mutableStateOf("")
    }

    var password by remember{
        mutableStateOf("")
    }


    Box(modifier = Modifier.fillMaxSize()) {
        Column (
            Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            LoginHeader()

            SignupFields(
                firstname,
                lastname,
                email,
                phonenumber,
                onFirstNameChange = {
                    firstname=it
                }, onLastNameChange = {
                    lastname=it
                },
                onEmailChange = {
                    email=it
                },
                onPhoneNumberChange = {
                    phonenumber=it
                })

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    onClick = {
                              navController.navigate(Route.HomePageScreen.route)
//                        onSignInClick2(
//                            email, password
//                        )
                    },
                    modifier=Modifier.fillMaxWidth()
                ) {
                    Text(text = "Register")
                }
//                TextButton(onClick = onSignUpClick*/) {
                    Text(
                        text = "Have an existing account? Login",
                        modifier = Modifier.clickable {
                            navController.navigate(Route.Login.route)
                        }
                    )
//                }
            }

//            LoginFooter(
//                navController,
//                onSignInClick = {},
//                onSignUpClick = {}
//            )

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
        horizontalAlignment = Alignment.CenterHorizontally
    )    {
        Text(
            text = "Register",
            fontSize=34.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}


@Composable
fun SignupFields(
    firstname: String,
    lastname: String,
    email: String,
    phonenumber : String,
                onFirstNameChange: (String) -> Unit,
                onLastNameChange: (String) -> Unit,
                onEmailChange: (String) -> Unit,
                onPhoneNumberChange: (String) -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        DemoField(
            value = firstname,
            label ="Firstname",
            placeholder = "Enter your firstname",
            onValueChange = onFirstNameChange,
            leadingIcon = {
                    Icon(Icons.Default.Person, contentDescription = "Firstname")
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        DemoField(value = lastname,
            label = "Lastname",
            placeholder = "Enter your lastname",
            onValueChange =onLastNameChange,
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Icon(
                    Icons.Default.Person,
                    contentDescription ="Lastname"
                )
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        DemoField(
            value = email,
            label = "Email",
            placeholder = "Enter your email",
            onValueChange =onEmailChange,
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription ="Email" )
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        DemoField(
            value = phonenumber,
            label = "Phone number",
            placeholder = "Enter your phone number",
            onValueChange =onPhoneNumberChange,
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Icon(Icons.Default.Phone, contentDescription ="Phone number" )
            }
        )
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
            onClick = onSignInClick,
            modifier=Modifier.fillMaxWidth()
        ) {
            Text(text = "Register")
        }
        TextButton(onClick = onSignUpClick) {
            Text(
                text = "Have an existing account? Login",
                modifier = Modifier.clickable {
                    navController.navigate(Route.Signup.route)
                }
            )
        }
    }


}


fun onSignInClick2(email: String, password: String) {

    lateinit var auth: FirebaseAuth;

    // Initialize Firebase Auth
    auth = Firebase.auth

    // Register account and sign in
    auth.signInWithEmailAndPassword("eb@gmail.com", "123456789")

//        .addOnCompleteListener(this) { task ->
//        if (task.isSuccessful) {
//            // Sign in success, update UI with the signed-in user's information
//            Log.d(TAG, "signInWithCustomToken:success")
//            val user = auth.currentUser
//            updateUI(user)
//        } else {
//            // If sign in fails, display a message to the user.
//            Log.w(TAG, "signInWithCustomToken:failure", task.exception)
//            Toast.makeText(baseContext, "Authentication failed.",
//                Toast.LENGTH_SHORT).show()
//            updateUI(null)
//        }
//    }
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
        modifier = Modifier.fillMaxWidth(),
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
        trailingIcon = trailingIcon
    )
}



@Preview(showBackground = true, showSystemUi= true)
@Composable
fun PrevSignupScreen(){
    SignupScreen(rememberNavController())
}