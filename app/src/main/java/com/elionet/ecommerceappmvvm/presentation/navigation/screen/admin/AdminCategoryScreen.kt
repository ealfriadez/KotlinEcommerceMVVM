package com.elionet.ecommerceappmvvm.presentation.navigation.screen.admin

sealed class AdminCategoryScreen(val route: String) {

    object CategoryCreate : AdminCategoryScreen(route = "admin/category/create")
    object CategoryUpdate : AdminCategoryScreen(route = "admin/category/update/{category}"){
        fun passCategory(category: String) = "admin/category/update/$category"
    }
}