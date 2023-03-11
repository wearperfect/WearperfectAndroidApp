package com.wearperfect.android.app.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.wearperfect.android.app.constant.navigation.Destination
import com.wearperfect.android.app.ui.screen.home.HomeScreen

fun NavGraphBuilder.homeScreenComposable(
    rootNavController: NavHostController,
    navigateToLogin: () -> Unit
){
    composable(
        route = Destination.HOME_SCREEN.route
    ){
        HomeScreen(
            rootNavController = rootNavController,
            navigateToLogin = navigateToLogin
        )
    }
}