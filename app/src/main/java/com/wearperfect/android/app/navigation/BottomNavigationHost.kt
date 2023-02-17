package com.wearperfect.android.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.wearperfect.android.app.constant.navigation.Destination
import com.wearperfect.android.app.navigation.navgraph.bottomNavGraph
import com.wearperfect.android.app.navigation.navigator.BottomNavBarNavigator

@Composable
fun BottomNavigationHost(
    navController: NavHostController,
    navigateToLogin: () -> Unit
) {

    val bottomNavBarNavigator = remember(navController){
        BottomNavBarNavigator(navController)
    }

    NavHost(
        navController = navController,
        startDestination = Destination.BOTTOM_NAV_GRAPH.route,
        route = Destination.BOTTOM_NAV_HOST.route
    ) {
        bottomNavGraph(
            navController = navController,
            navigateToLogin = navigateToLogin
        )
    }
}