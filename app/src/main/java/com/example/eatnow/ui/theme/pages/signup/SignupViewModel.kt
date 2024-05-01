package com.example.eatnow.ui.theme.pages.signup

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

class SignupViewModel : ViewModel() {
    private val auth = Firebase.auth
    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading
    var isLoading by mutableStateOf(false)
    var signupErr by mutableStateOf("")

    fun createUserWithEmailAndPassword(
        firstname : String,
        lastname : String,
        phoneNumber: String,
        email: String,
        password: String,
        home: () -> Unit,
    ) = viewModelScope.launch {
        if (isLoading == false) {
            isLoading = true

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        createUser(firstname, lastname, phoneNumber)
                        home()

                        Log.d("create suc", "${task.result}")
                    }

                    isLoading = false
                }.addOnFailureListener { task ->
                    Log.d("fail", "${task.message}")
                    signupErr = task.message.toString()
                }

        }
    }

    fun createUser(firstname: String, lastname: String, phoneNumber: String) {

    }

}
