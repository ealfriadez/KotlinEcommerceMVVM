package com.elionet.ecommerceappmvvm.presentation.screens.client.product.detail.components


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.elionet.ecommerceappmvvm.presentation.screens.client.product.detail.ClientProductDetailViewModel
import com.optic.ecommerceappmvvm.presentation.components.DotsIndicator
import com.optic.ecommerceappmvvm.presentation.components.SliderView
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientProductDetailContent(
    paddingValues: PaddingValues,
    vm: ClientProductDetailViewModel = hiltViewModel()
){
    val state = rememberPagerState(initialPage = 0) { vm.productImages.size }
    Column(
        Modifier.padding(paddingValues)
    ){
        SliderView(state = state, images = vm.productImages)
        Spacer(modifier = Modifier.height(4.dp))
        DotsIndicator(totalDots = vm.productImages.size, selectedIndex = state.currentPage)
    }

    LaunchedEffect(key1 = state.currentPage){
        delay(10000)
        var newPosition = state.currentPage + 1
        if(newPosition > vm.productImages.size - 1) newPosition = 0
        state.animateScrollToPage(newPosition)
    }
}