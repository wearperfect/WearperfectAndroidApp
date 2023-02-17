package com.wearperfect.android.app.navigation.destination

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.wearperfect.android.app.constant.navigation.Destination
import com.wearperfect.android.app.ui.screen.home.store.StoreScreen

fun NavGraphBuilder.storeScreenComposable(navController: NavHostController) {
    composable(
        route = Destination.STORE_SCREEN.route
    ){
        StoreScreen(navController = navController)
    }
}