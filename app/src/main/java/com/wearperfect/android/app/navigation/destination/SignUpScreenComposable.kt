package com.wearperfect.android.app.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.wearperfect.android.app.constant.navigation.Destination
import com.wearperfect.android.app.ui.screen.auth.SignUpScreen

fun NavGraphBuilder.signUpScreenComposable(
    navigateToLogIn: () -> Unit,
    navigateToHome: () -> Unit
){

    composable(
        route = Destination.SIGNUP_SCREEN.route
    ){
        SignUpScreen(
            navigateToLogIn = navigateToLogIn,
            navigateToHome = navigateToHome
        )
    }
}