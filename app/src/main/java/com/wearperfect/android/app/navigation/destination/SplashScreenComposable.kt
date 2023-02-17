package com.wearperfect.android.app.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.wearperfect.android.app.constant.navigation.Destination
import com.wearperfect.android.app.ui.screen.launch.SplashScreen

fun NavGraphBuilder.splashScreenComposable(rootNavController: NavHostController) {

    composable(
        route = Destination.SPLASH_SCREEN.route
    ){
        SplashScreen(rootNavController = rootNavController)
    }
}