package com.example.testing.ui.loginscreen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.testing.ui.mainscreen.MainActivity

import com.example.testing.ui.theme.TestingTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginActivity: ComponentActivity() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val intent: Intent = Intent(this, MainActivity::class.java)
        super.onCreate(savedInstanceState)



        setContent {
            TestingTheme {
                LoginComponent(viewModel = viewModel, context = this, intent = intent)
            }
        }
    }


}

