package com.wearperfect.android.app.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.wearperfect.android.app.constant.navigation.Destination
import com.wearperfect.android.app.navigation.destination.*

fun NavGraphBuilder.bottomNavGraph(
    navController: NavHostController,
    navigateToLogin: () -> Unit
){
    navigation(
        route = Destination.BOTTOM_NAV_GRAPH.route,
        startDestination = Destination.FEED_SCREEN.route
    ){
        feedScreenComposable(navController = navController)
        exploreScreenComposable(navController = navController)
        studioScreenComposable(navController = navController)
        storeScreenComposable(navController = navController)
        profileScreenComposable(
            navController = navController,
            navigateToLogin = navigateToLogin
        )
    }
}