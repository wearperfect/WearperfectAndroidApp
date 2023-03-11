package com.wearperfect.android.app.ui.screen.home.store

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.wearperfect.android.app.component.card.PerfectProductCard
import com.wearperfect.android.app.constant.network.RequestState
import com.wearperfect.android.app.data.dto.ProductDTO
import com.wearperfect.android.app.data.dto.ProductFilterDTO
import com.wearperfect.android.app.ui.viewmodel.ProductFilterViewModel

@Composable
fun StoreLatestTabContent(
    navController: NavHostController,
    productFilterViewModel: ProductFilterViewModel = hiltViewModel()
){

    val filteredProductsState by productFilterViewModel.filteredProductsStateFlow.collectAsState()

    LaunchedEffect(key1 = true) {
        productFilterViewModel.getFilteredProducts(
            ProductFilterDTO(manufacturerCategories = listOf(3,4)),
            0,
            10
        )
    }
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            //modifier = Modifier.background(color = Color.LightGray),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(filteredProductsState is RequestState.Success<List<ProductDTO>>){
                LazyVerticalGrid(
                    modifier = Modifier.padding(top = 0.dp),
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(0.dp),
                    verticalArrangement = Arrangement.spacedBy((0).dp),
                    horizontalArrangement = Arrangement.spacedBy((-8).dp)
                ) {
                    items(
                        items = (filteredProductsState as RequestState.Success<List<ProductDTO>>).data,
                        key = {product -> product.id}
                    ){ product ->
                        PerfectProductCard(product = ((filteredProductsState as RequestState.Success<List<ProductDTO>>).data)[0])
                    }
                }
            }else{
                Text(text = "No Latest Things.")
            }
        }
    }
}