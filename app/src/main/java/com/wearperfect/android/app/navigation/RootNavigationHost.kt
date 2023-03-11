package com.wearperfect.android.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.wearperfect.android.app.constant.navigation.Destination
import com.wearperfect.android.app.navigation.navgraph.authNavGraph
import com.wearperfect.android.app.navigation.navgraph.homeNavGraph
import com.wearperfect.android.app.navigation.navgraph.launchNavGraph
import com.wearperfect.android.app.navigation.navigator.RootNavigator

@Composable
fun RootNavigationHost(
    rootNavController: NavHostController
){

    val rootNavigator = remember(rootNavController){
        RootNavigator(rootNavController)
    }

    NavHost(
        navController = rootNavController,
        startDestination = Destination.LAUNCH_NAV_GRAPH.route,
        route = Destination.ROOT_NAV_GRAPH.route
    ){
        launchNavGraph(
            rootNavController = rootNavController
        )
        authNavGraph(
            navigateToLogIn = rootNavigator.navigateToLogIn,
            navigateToLogInHelp = rootNavigator.navigateToLogInHelp,
            navigateToSignUp = rootNavigator.navigateToSignUp,
            navigateToHome = rootNavigator.navigateToHome
        )
        homeNavGraph(
            rootNavController = rootNavController,
            navigateToLogin = rootNavigator.navigateToLogIn
        )
    }
}