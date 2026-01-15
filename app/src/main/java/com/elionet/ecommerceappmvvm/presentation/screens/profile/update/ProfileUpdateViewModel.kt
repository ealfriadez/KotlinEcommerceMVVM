package com.elionet.ecommerceappmvvm.presentation.screens.profile.update

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.elionet.ecommerceappmvvm.domain.model.User
import com.elionet.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import java.net.URLDecoder
import javax.inject.Inject
import android.util.Log

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val savedStateHandle: SavedStateHandle
): ViewModel(){

    var state by mutableStateOf(ProfileUpdateState())
        private set

    //ARGUMENTS
    val data = savedStateHandle.get<String>("user")

    /*val user = User.fromJson(data!!)*/

    // Decodificamos el String antes de pasarlo a fromJson
    val user = User.fromJson(URLDecoder.decode(data!!, "UTF-8"))

    init{

        Log.d("ProfileUpdateViewModel", "URL de la imagen: ${user.image}")

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