package com.wearperfect.android.app.ui.screen.launch

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.wearperfect.android.app.R
import com.wearperfect.android.app.constant.navigation.Destination
import com.wearperfect.android.app.constant.network.RequestState
import com.wearperfect.android.app.ui.viewmodel.AccountViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    rootNavController: NavHostController,
    accountViewModel: AccountViewModel = hiltViewModel()
) {

    val logInState by accountViewModel.logInStateFlow.collectAsState()

    LaunchedEffect(key1 = true) {
        accountViewModel.verifyLogin()
    }

    LaunchedEffect(key1 = logInState, block = {
        delay(500)
        if (logInState is RequestState.Success<Boolean>){
            Log.i("SplashScreen", "SplashScreen LaunchedEffect: isLoggedIn: ${(logInState as RequestState.Success<Boolean>)}")
            if ((logInState as RequestState.Success<Boolean>).data) {
                rootNavController.navigate(Destination.HOME_NAV_GRAPH.route) {
                    popUpTo(Destination.ROOT_NAV_GRAPH.route) { inclusive = true }
                    launchSingleTop = true
                }
            } else {
                rootNavController.navigate(Destination.AUTH_NAV_GRAPH.route) {
                    popUpTo(Destination.ROOT_NAV_GRAPH.route) { inclusive = true }
                    launchSingleTop = true
                }
            }
        }
    })

    Surface(
        color = MaterialTheme.colors.background,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_wearperfect_logo),
                contentDescription = "Wearperfect Logo."
            )
        }
    }
}