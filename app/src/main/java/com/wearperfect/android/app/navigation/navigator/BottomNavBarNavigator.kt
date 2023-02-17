package com.wearperfect.android.app.navigation.navigator

import androidx.navigation.NavHostController
import com.wearperfect.android.app.constant.navigation.Destination

class BottomNavBarNavigator(navController: NavHostController) {

    val navigateToMain: () -> Unit = {
        navController.navigate(Destination.MAIN_NAV_GRAPH.route){
            popUpTo(Destination.AUTH_NAV_GRAPH.route) {inclusive = true}
            launchSingleTop = true
        }
    }
}