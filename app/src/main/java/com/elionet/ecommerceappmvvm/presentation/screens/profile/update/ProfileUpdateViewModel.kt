package com.elionet.ecommerceappmvvm.presentation.screens.profile.update

import android.content.Context
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
import androidx.lifecycle.viewModelScope
import com.elionet.ecommerceappmvvm.presentation.util.ComposeFileProvider
import com.elionet.ecommerceappmvvm.presentation.util.ResultingActivityHandler
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val savedStateHandle: SavedStateHandle,
    @ApplicationContext private val context: Context
): ViewModel(){

    var state by mutableStateOf(ProfileUpdateState())
        private set

    //ARGUMENTS
    val data = savedStateHandle.get<String>("user")

    // Decodificamos el String antes de pasarlo a fromJson
    val user = User.fromJson(URLDecoder.decode(data!!, "UTF-8"))

    //IMAGENES
    var file: File? = null
    val resultingActivityHandler= ResultingActivityHandler()

    init{

        Log.d("ProfileUpdateViewModel", "URL de la imagen: ${user.image}")

        state = state.copy(
            name = user.name,
            lastName = user.lastname,
            phone = user.phone,
            image = user.image ?: ""
        )
    }

    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*")
        if(result != null){
            file = ComposeFileProvider.createFileFromUri(context, result)
            state = state.copy(image = result.toString())
        }
    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null){
            state = state.copy(image = ComposeFileProvider.getPathFromBitmap(context, result))
            file = File(state.image)
        }
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