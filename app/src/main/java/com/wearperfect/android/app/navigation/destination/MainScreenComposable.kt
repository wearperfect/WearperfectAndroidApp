package com.wearperfect.android.app.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.wearperfect.android.app.constant.navigation.Destination
import com.wearperfect.android.app.ui.screen.MainScreen

fun NavGraphBuilder.mainScreenComposable(
    rootNavController: NavHostController,
    navigateToLogin: () -> Unit
){
    composable(
        route = Destination.MAIN_SCREEN.route
    ){
        MainScreen(
            rootNavController = rootNavController,
            navigateToLogin = navigateToLogin
        )
    }
}