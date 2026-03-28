package com.elionet.ecommerceappmvvm.presentation.navigation.screen.client

import com.elionet.ecommerceappmvvm.presentation.navigation.screen.admin.AdminOrderScreen

sealed class ClientOrderScreen(val route: String) {

    object OrderDetail: ClientOrderScreen("client/order/detail/{order}") {
        fun passOrder(order: String) = "client/order/detail/$order"
    }

   //object OrderDetail: AdminOrderScreen("admin/order/detail")

}

