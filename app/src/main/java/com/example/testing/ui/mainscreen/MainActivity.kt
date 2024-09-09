package com.example.testing.ui.mainscreen

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.testing.ui.theme.TestingTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainScreenVIewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestingTheme {
                    test(viewModel = viewModel, context = this)
                }
            }
        }




    }

@Composable
fun test(viewModel: MainScreenVIewModel, context: Context) {
    if (viewModel.state.value.isLoading) {
        CircularProgressIndicator()
    }
    if (viewModel.state.value.error != "") {
        Toast.makeText(context, viewModel.state.value.error, Toast.LENGTH_LONG).show()
    }

    Text(text = viewModel.state.value.data.toString())
}
