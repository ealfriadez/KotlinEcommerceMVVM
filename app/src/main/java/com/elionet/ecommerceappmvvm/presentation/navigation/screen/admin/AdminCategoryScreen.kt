package com.elionet.ecommerceappmvvm.presentation.navigation.screen.admin

sealed class AdminCategoryScreen(val route: String) {

    object CategoryCreate : AdminCategoryScreen(route = "admin/category/create")
    //object CategoryList : AdminCategoryScreen(route = "admin/category/list")
}