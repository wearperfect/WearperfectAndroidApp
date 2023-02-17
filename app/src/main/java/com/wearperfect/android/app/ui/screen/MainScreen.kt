package com.wearperfect.android.app.ui.screen

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.wearperfect.android.app.component.appbar.PerfectBottomNavigationAppBar
import com.wearperfect.android.app.constant.navigation.BottomNavigationDestination
import com.wearperfect.android.app.constant.navigation.Destination
import com.wearperfect.android.app.constant.network.RequestState
import com.wearperfect.android.app.navigation.BottomNavigationHost
import com.wearperfect.android.app.ui.viewmodel.AccountViewModel

@Composable
fun MainScreen(
    rootNavController: NavHostController,
    navigateToLogin: () -> Unit
) {


    val navController: NavHostController = rememberNavController()
    val destinations = listOf<BottomNavigationDestination>(
        BottomNavigationDestination.Feed,
        BottomNavigationDestination.Store,
        BottomNavigationDestination.Studio,
        BottomNavigationDestination.Explore,
        BottomNavigationDestination.Profile
    )

    Scaffold(
        modifier = Modifier,
        bottomBar = {
            PerfectBottomNavigationAppBar(
                navController = navController,
                destinations = destinations
            )
        }
    ) {
        Log.i("TAG", "MainScreen: $it")
        BottomNavigationHost(
            navController = navController,
            navigateToLogin = navigateToLogin
        )
    }
}