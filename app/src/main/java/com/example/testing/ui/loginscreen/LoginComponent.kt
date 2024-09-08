package com.example.testing.ui.loginscreen



import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun LoginComponent(viewModel: LoginViewModel, context: Context, intent: Intent) {

    val state = viewModel.state.value

    if (state.isLoading) {
        CircularProgressIndicator()
    }

    if (state.error != "") {
        Toast.makeText(context, state.error, Toast.LENGTH_LONG).show()
    }

    if (state.permission) {
        context.startActivity(intent)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        // LOGIN
        TextField(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 20.dp),
            value = viewModel.username.value,
            onValueChange = { newText -> viewModel.username.value = newText },
            placeholder = { Text("логин") },
            singleLine = true,
            shape = RoundedCornerShape(25.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            )
        )


        // PASSWORD
        TextField(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 20.dp),
            value = viewModel.password.value,
            onValueChange = { newText -> viewModel.password.value = newText },
            placeholder = { Text("пароль") },
            singleLine = true,
            shape = RoundedCornerShape(25.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            )
        )


        // BUTTON LOGIN
        Button(
            onClick = {
                viewModel.login()
            },
            modifier = Modifier.padding(end = 10.dp, start = 10.dp)
        ) {
            Text("Войти")
        }


    }

}