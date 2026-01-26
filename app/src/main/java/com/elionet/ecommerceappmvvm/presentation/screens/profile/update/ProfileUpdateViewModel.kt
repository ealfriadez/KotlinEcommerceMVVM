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
import com.elionet.ecommerceappmvvm.domain.useCase.users.UsersUseCase
import com.elionet.ecommerceappmvvm.domain.util.Resource
import com.elionet.ecommerceappmvvm.presentation.screens.profile.update.mapper.toUser
import com.elionet.ecommerceappmvvm.presentation.util.ComposeFileProvider
import com.elionet.ecommerceappmvvm.presentation.util.ResultingActivityHandler
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val usersUseCase: UsersUseCase,
    private val savedStateHandle: SavedStateHandle,
    @ApplicationContext private val context: Context
): ViewModel(){

    var state by mutableStateOf(ProfileUpdateState())
        private set

    //ARGUMENTS
    val data = savedStateHandle.get<String>("user")

    // Decodificamos el String antes de pasarlo a fromJson
    var user = User.fromJson(URLDecoder.decode(data!!, "UTF-8"))

    //IMAGENES
    var file: File? = null
    val resultingActivityHandler= ResultingActivityHandler()

    var updateResponse by mutableStateOf<Resource<User>?>(null)
        private set


    init{

        Log.d("ProfileUpdateViewModel", "URL de la imagen: ${user}")

        state = state.copy(
            name = user.name,
            lastName = user.lastname,
            phone = user.phone,
            image = user.image ?: ""
        )
    }

    fun updateUserSession() = viewModelScope.launch {
        authUseCase.updateSession(state.toUser())
    }

    fun update() = viewModelScope.launch {

        updateResponse = Resource.Loading

        Log.d("ProfileUpdateViewModel - 3", "URL de la imagen: ${updateResponse.toString()}")

        val result = usersUseCase.updateUser(user.id ?: "", state.toUser())

        updateResponse = result

        Log.d("ProfileUpdateViewModel - 4", "URL de la imagen: ${result}")
    }

    fun logout() = viewModelScope.launch {
        authUseCase.logout()

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