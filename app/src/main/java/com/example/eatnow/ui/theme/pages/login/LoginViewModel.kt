package com.example.eatnow.ui.theme.pages.login

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

class LoginViewModel : ViewModel() {
    //    val loadingState = MutableStateFlow(LoadingState.IDLE)
    private val auth = Firebase.auth
    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    var isLoading by mutableStateOf(false)
    var loginErr by mutableStateOf("")
    var isLogout by mutableStateOf(false)

    fun signInWithEmailAndPassword(email: String, password: String, home: () -> Unit) =
        viewModelScope.launch {
            isLoading = true
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("FB", "signin good : ${task.result}")
                        isLogout = false
                        home()
                    }
                    isLoading = false
                }.addOnFailureListener { result ->
                    Log.d("FB", "signin bad : ${result.message}")
                    loginErr = result.message.toString()
                }
        }

    fun signOut() {
        auth.signOut()
        isLogout = true
    }

}
