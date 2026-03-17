package com.elionet.ecommerceappmvvm.presentation.screens.client.shopping_bag

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elionet.ecommerceappmvvm.domain.model.ShoppingBagProduct
import com.elionet.ecommerceappmvvm.domain.useCase.shopping_bag.ShoppingBagUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientShoppingBagViewModel @Inject constructor(
    private val shoppingBagUseCase: ShoppingBagUseCase
): ViewModel() {

    var shoppingBag = mutableStateListOf<ShoppingBagProduct>()
        private set

    var total by mutableStateOf(0.0)
        private set

    init {
        getShoppingBag()
    }

    fun getTotal(){
        total = 0.0
        shoppingBag.forEach {
            total = total + (it.price * it.quantity)
        }
    }

    fun getShoppingBag() = viewModelScope.launch{
        shoppingBagUseCase.findAll().collect() {
            shoppingBag.clear()
            shoppingBag.addAll(it)
            getTotal()
        }
    }

    fun addItem(shoppingBagProduct: ShoppingBagProduct) = viewModelScope.launch{
        shoppingBagProduct.quantity += 1
        shoppingBagUseCase.add(shoppingBagProduct)
        getTotal()
    }

    fun substracItem(shoppingBagProduct: ShoppingBagProduct) = viewModelScope.launch {
        if (shoppingBagProduct.quantity > 1)
        {
            shoppingBagProduct.quantity -= 1
            shoppingBagUseCase.add(shoppingBagProduct)
            getTotal()
        }
    }

    fun deleteItem(id: String) = viewModelScope.launch{
        shoppingBagUseCase.delete(id)
        getTotal()
    }
}