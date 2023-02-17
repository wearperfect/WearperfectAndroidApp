package com.wearperfect.android.app.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.wearperfect.android.app.constant.navigation.Destination
import com.wearperfect.android.app.navigation.destination.logInScreenComposable
import com.wearperfect.android.app.navigation.destination.loginHelpScreenComposable
import com.wearperfect.android.app.navigation.destination.signUpScreenComposable

fun NavGraphBuilder.authNavGraph(
    navigateToLogIn: () -> Unit,
    navigateToLogInHelp: () -> Unit,
    navigateToSignUp: () -> Unit,
    navigateToMain: () -> Unit,
){
    navigation(
        route = Destination.AUTH_NAV_GRAPH.route,
        startDestination = Destination.LOGIN_SCREEN.route
    ){
        logInScreenComposable(
            navigateToLogInHelp = navigateToLogInHelp,
            navigateToSignUp = navigateToSignUp,
            navigateToMain = navigateToMain
        )
        loginHelpScreenComposable(
            navigateToLogIn = navigateToLogIn
        )
        signUpScreenComposable(
            navigateToLogIn = navigateToLogIn,
            navigateToMain = navigateToMain
        )
    }
}