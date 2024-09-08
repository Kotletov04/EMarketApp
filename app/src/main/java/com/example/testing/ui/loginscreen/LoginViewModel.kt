package com.example.testing.ui.loginscreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.Resource
import com.example.domain.usecase.LoginUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUsecase: LoginUsecase): ViewModel() {

    val username = mutableStateOf("")
    val password = mutableStateOf("")
    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state


    fun login() {
        loginUsecase(username = username.value, password = password.value).onEach { result ->

            when (result) {

                is Resource.Loading -> {
                    _state.value = LoginState(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value = LoginState(error = "Пользователь не найден")
                }

                is Resource.Success -> {
                    _state.value = LoginState(permission = true)
                }

            }

        }.launchIn(viewModelScope)
    }

}