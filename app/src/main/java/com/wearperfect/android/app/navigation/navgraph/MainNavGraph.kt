package com.wearperfect.android.app.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.wearperfect.android.app.constant.navigation.Destination
import com.wearperfect.android.app.navigation.destination.mainScreenComposable

fun NavGraphBuilder.mainNavGraph(
    rootNavController: NavHostController,
    navigateToLogin: ()->Unit
){

    navigation(
        route = Destination.MAIN_NAV_GRAPH.route,
        startDestination = Destination.MAIN_SCREEN.route
    ){
        mainScreenComposable(
            rootNavController = rootNavController,
            navigateToLogin = navigateToLogin
        )
    }
}