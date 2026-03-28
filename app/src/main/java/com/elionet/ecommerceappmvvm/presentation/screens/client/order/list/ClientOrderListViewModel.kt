package com.elionet.ecommerceappmvvm.presentation.screens.client.order.list

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elionet.ecommerceappmvvm.domain.model.Order
import com.elionet.ecommerceappmvvm.domain.model.User
import com.elionet.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.orders.OrdersUseCase
import com.elionet.ecommerceappmvvm.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientOrderListViewModel @Inject constructor(
    private val ordersUseCase: OrdersUseCase,
    private val authUseCase: AuthUseCase
): ViewModel() {

    var user by mutableStateOf<User?>(null)
        private set
    var ordersResponse by mutableStateOf<Resource<List<Order>>?>(null)
        private set

    fun getSessionData() = viewModelScope.launch {
        user = authUseCase.getSessionData().first().user
        getOrdersByClient(user?.id ?: "")
    }

    fun getOrdersByClient(idClient: String) = viewModelScope.launch {
        ordersResponse = Resource.Loading
        ordersUseCase.findByClientOrders(idClient).collect() {
            ordersResponse = it
        }
    }

}