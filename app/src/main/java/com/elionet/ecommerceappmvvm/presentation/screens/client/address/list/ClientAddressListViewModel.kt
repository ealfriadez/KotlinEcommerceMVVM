package com.elionet.ecommerceappmvvm.presentation.screens.client.address.list

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elionet.ecommerceappmvvm.domain.model.Address
import com.elionet.ecommerceappmvvm.domain.model.CheckoutRequest
import com.elionet.ecommerceappmvvm.domain.model.CheckoutResponse
import com.elionet.ecommerceappmvvm.domain.model.User
import com.elionet.ecommerceappmvvm.domain.useCase.address.AddressUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.mercado_pago_checkout.MercadoPagoCheckoutUseCases
import com.elionet.ecommerceappmvvm.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class  ClientAddressListViewModel @Inject constructor(
    private val addressUseCase: AddressUseCase,
    private val authUseCase: AuthUseCase,
    private val mercadoPagoCheckoutUseCases: MercadoPagoCheckoutUseCases
): ViewModel() {

    var addressResponse by mutableStateOf<Resource<List<Address>>?>(null)
        private set

    var mercadoPagoCheckoutResponse by mutableStateOf<Resource<CheckoutResponse>?>(null)
        private set

    var selectedAddress by mutableStateOf("")
        private set

    var user: User? = null

    fun getSessionData() = viewModelScope.launch {
        user = authUseCase.getSessionData().first().user
        Log.d("ClientAddressListViewModel", "User: $user")

        getAddress(user?.id ?: "")
        if(user?.address != null){
            selectedAddress = user?.address?.id ?: ""
        }
    }

    fun getAddress(idUser: String) = viewModelScope.launch {
        addressResponse = Resource.Loading
        addressUseCase.findByUserAddress(idUser).collect() {
            Log.d("ClientAddressListViewModel", "Data: $it")
            addressResponse = it
        }
    }

    fun onSelectedAddressInput(address: Address) = viewModelScope.launch{
        selectedAddress = address.id ?: ""
        user?.address = address
        if(user != null) authUseCase.updateSession(user!!)
    }

    fun launchMercadoPagoCheckout() = viewModelScope.launch {
        val result = mercadoPagoCheckoutUseCases.createCheckoutPreference(CheckoutRequest(
            title = "Tronsmart Bang SE",
            quantity = 1,
            unit_price = 250.00
        ))
        mercadoPagoCheckoutResponse = result
    }

}