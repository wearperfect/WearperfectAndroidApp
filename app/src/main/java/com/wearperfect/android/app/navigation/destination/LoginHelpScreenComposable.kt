package com.wearperfect.android.app.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.wearperfect.android.app.constant.navigation.Destination
import com.wearperfect.android.app.ui.screen.auth.LoginHelpScreen

fun NavGraphBuilder.loginHelpScreenComposable(
    navigateToLogIn: () -> Unit,
){
    composable(route = Destination.LOGIN_HELP_SCREEN.route){
        LoginHelpScreen(
            navigateToLogIn = navigateToLogIn
        )
    }
}