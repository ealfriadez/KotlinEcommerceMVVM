package com.elionet.ecommerceappmvvm.presentation.screens.client.shopping_bag

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

    var shoppingBag = mutableListOf<ShoppingBagProduct>()
        private set

    init {
        getShoppingBag()
    }

    fun getShoppingBag() = viewModelScope.launch{
        shoppingBagUseCase.findAll().collect() {
            shoppingBag.clear()
            shoppingBag.addAll(it)
        }
    }

    fun addItem(shoppingBagProduct: ShoppingBagProduct) = viewModelScope.launch{
        shoppingBagProduct.quantity += 1
        shoppingBagUseCase.add(shoppingBagProduct)
    }

    fun substracItem(shoppingBagProduct: ShoppingBagProduct) = viewModelScope.launch{
        shoppingBagProduct.quantity -= 1
        shoppingBagUseCase.add(shoppingBagProduct)
    }

    fun deleteItem(id: String) = viewModelScope.launch{
        shoppingBagUseCase.delete(id)
    }
}