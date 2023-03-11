package com.wearperfect.android.app.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.wearperfect.android.app.constant.navigation.Destination
import com.wearperfect.android.app.navigation.destination.homeScreenComposable

fun NavGraphBuilder.homeNavGraph(
    rootNavController: NavHostController,
    navigateToLogin: ()->Unit
){

    navigation(
        route = Destination.HOME_NAV_GRAPH.route,
        startDestination = Destination.HOME_SCREEN.route
    ){
        homeScreenComposable(
            rootNavController = rootNavController,
            navigateToLogin = navigateToLogin
        )
    }
}