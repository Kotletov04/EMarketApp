package com.example.testing.ui.mainscreen

data class MainScreenState(
    val isLoading: Boolean = false,
    val error: String = "",
    val permission: Boolean = false
)