package com.elionet.ecommerceappmvvm.presentation.screens.admin.category.create

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elionet.ecommerceappmvvm.domain.model.Category
import com.elionet.ecommerceappmvvm.domain.useCase.categories.CategoriesUseCase
import com.elionet.ecommerceappmvvm.domain.util.Resource
import com.elionet.ecommerceappmvvm.presentation.screens.admin.category.create.mapper.toCategory
import com.elionet.ecommerceappmvvm.presentation.screens.profile.update.mapper.toUser
import com.elionet.ecommerceappmvvm.presentation.util.ComposeFileProvider
import com.elionet.ecommerceappmvvm.presentation.util.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AdminCategoryCreateViewModel @Inject constructor(
    private val categoriesUseCase: CategoriesUseCase,
    @ApplicationContext private val context: Context
): ViewModel() {

    var state by mutableStateOf(AdminCategoryCreateState())
        private set

    var categoryResponse by mutableStateOf<Resource<Category>?>(null)
        private set

    var file: File? = null

    val resultingActivityHandler= ResultingActivityHandler()

    fun createCategory() = viewModelScope.launch {
        if(file != null){
            categoryResponse = Resource.Loading
            val result = categoriesUseCase.createCategory(state.toCategory(), file!!)
            categoryResponse = result
        }
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

    fun clearForm(){
        state = state.copy(
            name = "",
            description = "",
            image = ""
        )
        categoryResponse = null
    }

    fun onNameInput(name: String){
        state = state.copy(name = name)
    }

    fun onDescriptionInput(description: String){
        state = state.copy(description = description)
    }
}