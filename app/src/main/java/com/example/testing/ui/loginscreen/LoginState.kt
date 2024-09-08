package com.example.testing.ui.loginscreen

data class LoginState(
    val isLoading: Boolean = false,
    val error: String = "",
    val permission: Boolean = false
)
