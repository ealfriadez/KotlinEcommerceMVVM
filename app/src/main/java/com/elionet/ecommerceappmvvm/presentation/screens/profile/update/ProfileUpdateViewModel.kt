package com.elionet.ecommerceappmvvm.presentation.screens.profile.update

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elionet.ecommerceappmvvm.domain.model.User
import com.elionet.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val savedStateHandle: SavedStateHandle
): ViewModel(){

    var state by mutableStateOf(ProfileUpdateState())
        private set

    //ARGUMENTS
    val data = savedStateHandle.get<String>("user")
    val user = User.fromJson(data!!)

    init{
        state = state.copy(
            name = user.name,
            lastName = user.lastname,
            phone = user.phone,
            image = user.image ?: ""
        )
    }

    fun onNameInput(name: String){
        state = state.copy(name = name)
    }

    fun onLastNameInput(lastName: String){
        state = state.copy(lastName = lastName)
    }

    fun onPhoneInput(phone: String){
        state = state.copy(phone = phone)
    }

    fun onImageInput(image: String){
        state = state.copy(image = image)
    }


}