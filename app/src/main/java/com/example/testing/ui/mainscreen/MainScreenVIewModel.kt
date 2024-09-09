package com.example.testing.ui.mainscreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.domain.common.Resource
import com.example.domain.usecase.ProductsUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class MainScreenVIewModel @Inject constructor(private val productsUsecase: ProductsUsecase): ViewModel() {

    private val _state = mutableStateOf(MainScreenState())
    val state: State<MainScreenState> = _state

    init {
        getProducts()
    }

    private fun getProducts() {
        productsUsecase().onEach { result ->

            when (result) {

                is Resource.Loading -> {
                    _state.value = MainScreenState(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value = MainScreenState(error = result.message.toString())
                }

                is Resource.Success -> {
                    _state.value = MainScreenState(data = result.data)
                }

            }

        }
    }


}