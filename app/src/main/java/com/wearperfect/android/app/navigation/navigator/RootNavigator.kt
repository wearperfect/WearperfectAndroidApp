package com.wearperfect.android.app.navigation.navigator

import androidx.navigation.NavHostController
import com.wearperfect.android.app.constant.navigation.Destination

class RootNavigator(rootNavController: NavHostController) {

    val navigateToLogIn: () -> Unit = {
        rootNavController.navigate(Destination.LOGIN_SCREEN.route){
            popUpTo(Destination.AUTH_NAV_GRAPH.route) {inclusive = true}
            launchSingleTop = true
        }
    }
    val navigateToSignUp: () -> Unit = {
        rootNavController.navigate(Destination.SIGNUP_SCREEN.route){
            popUpTo(Destination.MAIN_NAV_GRAPH.route) {inclusive = true}
            launchSingleTop = true
        }
    }
    val navigateToLogInHelp: () -> Unit = {
        rootNavController.navigate(Destination.LOGIN_HELP_SCREEN.route){
            popUpTo(Destination.MAIN_NAV_GRAPH.route) {inclusive = true}
            launchSingleTop = true
        }
    }
    val navigateToMain: () -> Unit = {
        rootNavController.navigate(Destination.MAIN_SCREEN.route){
            popUpTo(Destination.ROOT_NAV_GRAPH.route) {inclusive = true}
            launchSingleTop = true
        }
    }
}