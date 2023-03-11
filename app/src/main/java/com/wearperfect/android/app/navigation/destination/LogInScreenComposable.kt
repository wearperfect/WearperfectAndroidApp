package com.wearperfect.android.app.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.wearperfect.android.app.constant.navigation.Destination
import com.wearperfect.android.app.ui.screen.auth.LogInScreen

fun NavGraphBuilder.logInScreenComposable(
    navigateToLogInHelp: () -> Unit,
    navigateToSignUp: () -> Unit,
    navigateToHome: () -> Unit
){

    composable(
        route = Destination.LOGIN_SCREEN.route
    ){
        LogInScreen(
            navigateToLogInHelp = navigateToLogInHelp,
            navigateToSignUp = navigateToSignUp,
            navigateToHome = navigateToHome
        )
    }
}