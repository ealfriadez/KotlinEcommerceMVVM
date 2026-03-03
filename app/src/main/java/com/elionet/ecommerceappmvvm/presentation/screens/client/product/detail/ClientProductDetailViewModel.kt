package com.elionet.ecommerceappmvvm.presentation.screens.client.product.detail

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elionet.ecommerceappmvvm.domain.model.Product
import com.elionet.ecommerceappmvvm.domain.model.ShoppingBagProduct
import com.elionet.ecommerceappmvvm.domain.useCase.shopping_bag.ShoppingBagUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientProductDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val shoppingBagUseCase: ShoppingBagUseCase
): ViewModel() {

    var data = savedStateHandle.get<String>("product")
    var product = Product.fromJson(data!!)
    var productImages = listOf<String>(product.image1 ?: "", product.image2 ?:"")

    var quantity by mutableStateOf(0)
        private set

    var price by mutableStateOf(0.0)
        private set

    init{
        getShoppingBagProduct()
    }

    fun add() {
        quantity++
        price = product.price * quantity
    }

    fun remove() {
        if(quantity > 0) quantity--
        price = product.price * quantity
    }

    fun getShoppingBagProduct() = viewModelScope.launch {
        val result = shoppingBagUseCase.findById(product.id ?: "")
        quantity = result.quantity
        price = product.price * quantity
    }


    fun saveItem() = viewModelScope.launch {
        if(quantity > 0){
            val shoppingBagProduct = ShoppingBagProduct(
                id = product.id ?: "",
                name = product.name,
                idCategory = product.idCategory,
                image1 = product.image1 ?: "",
                price = product.price,
                quantity = quantity
            )
            shoppingBagUseCase.add(shoppingBagProduct)
        }
    }
}