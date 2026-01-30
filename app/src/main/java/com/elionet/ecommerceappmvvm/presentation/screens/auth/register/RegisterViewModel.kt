package com.elionet.ecommerceappmvvm.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elionet.ecommerceappmvvm.domain.model.AuthResponse
import com.elionet.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import com.elionet.ecommerceappmvvm.domain.util.Resource
import com.elionet.ecommerceappmvvm.presentation.screens.auth.register.mapper.toUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel(){

    var state by mutableStateOf(RegisterState())
        private set

    var errorMessage by mutableStateOf("")

    var registerResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }

    fun register() = viewModelScope.launch {
        if(isValidForm()) {
            registerResponse = Resource.Loading
            val result = authUseCase.register(state.toUser())
            registerResponse = result //DATA / ERROR
        }
    }

    fun onNameInput(name: String){
        state = state.copy(name = name)
    }

    fun onLastNameInput(lastName: String){
        state = state.copy(lastName = lastName)
    }

    fun onEmailInput(email: String){
        state = state.copy(email = email)
    }

    fun onPhoneInput(phone: String){
        state = state.copy(phone = phone)
    }

    fun onPasswordInput(password: String){
        state = state.copy(password = password)
    }

    fun onConfirmPasswordInput(confirmPassword: String){
        state = state.copy(confirmPassword = confirmPassword)
    }

    fun isValidForm(): Boolean {
        if(state.name == ""){
            errorMessage = "El nombre es requerido"
            return false
        }else if(state.lastName == ""){
            errorMessage = "El apellido es requerido"
            return false
        }else if(state.email == ""){
            errorMessage = "El email es requerido"
            return false
        }else if(state.phone == ""){
            errorMessage = "El telefono es requerido"
            return false
        }else if(state.password == ""){
            errorMessage = "La contraseña es requerida"
            return false
        }else if(state.confirmPassword == ""){
            errorMessage = "La confirmacion de contraseña es requerida"
            return false
        }else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "El email es invalido"
            return false
        }else if (state.password.length < 6) {
            errorMessage = "La contraseña debe tener al menos 6 caracteres"
            return false
        }else if (state.password != state.confirmPassword) {
            errorMessage = "Las contraseñas no coinciden"
            return false
        }
        return true
    }
}