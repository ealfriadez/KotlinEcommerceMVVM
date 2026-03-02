package com.optic.ecommerceappmvvm.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.elionet.ecommerceappmvvm.R
import com.elionet.ecommerceappmvvm.ui.theme.Gray100

@Composable
fun SliderView(
    state: PagerState,
    images: List<String>) {
    // 2. Crea el estado AQUÍ adentro vinculando el conteo al tamaño de la lista
    val state = rememberPagerState(pageCount = { images.size })

    HorizontalPager(
        state = state,
        modifier = Modifier
            .height(400.dp)
            .fillMaxWidth()
            .background(color = Gray100)
    ) { page ->
        // 3. Ahora 'page' nunca será mayor que el tamaño de la lista
        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(images[page]) // Aquí ocurría el error
                .scale(Scale.FILL)
                .build(),
            placeholder = painterResource(id = R.drawable.user_image)
        )

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
        }
    }
}