package com.wearperfect.android.app.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.wearperfect.android.app.constant.navigation.Destination
import com.wearperfect.android.app.ui.screen.home.profile.ProfileScreen

fun NavGraphBuilder.profileScreenComposable(
    navController: NavHostController,
    navigateToLogin: () -> Unit
){

    composable(
        route = Destination.PROFILE_SCREEN.route
    ){
        ProfileScreen(
            navController = navController,
            navigateToLogin = navigateToLogin
        )
    }
}