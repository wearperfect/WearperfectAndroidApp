package com.wearperfect.android.app.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.wearperfect.android.app.constant.navigation.Destination
import com.wearperfect.android.app.navigation.destination.splashScreenComposable

fun NavGraphBuilder.launchNavGraph(rootNavController: NavHostController){
    navigation(
        route = Destination.LAUNCH_NAV_GRAPH.route,
        startDestination = Destination.SPLASH_SCREEN.route
    ){
        splashScreenComposable(rootNavController = rootNavController)
    }
}