package com.wearperfect.android.app.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.wearperfect.android.app.constant.navigation.Destination
import com.wearperfect.android.app.ui.screen.home.studio.StudioScreen

fun NavGraphBuilder.studioScreenComposable(navController: NavHostController){

    composable(
        route = Destination.STUDIO_SCREEN.route
    ){
        StudioScreen(navController = navController)
    }
}