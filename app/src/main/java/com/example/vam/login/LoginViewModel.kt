package com.example.vam.login

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(){

    enum class AuthenticationState{
        AUTHENTICATED, UNAUTHENTICATED
    }

}