package com.wearperfect.android.app.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.wearperfect.android.app.constant.navigation.Destination
import com.wearperfect.android.app.ui.screen.home.explore.ExploreScreen

fun NavGraphBuilder.exploreScreenComposable(navController: NavHostController){
    
    composable(
        route = Destination.EXPLORE_SCREEN.route
    ){
        ExploreScreen(navController = navController)
    }
}