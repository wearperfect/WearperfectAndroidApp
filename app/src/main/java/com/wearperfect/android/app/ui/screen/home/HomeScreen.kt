package com.wearperfect.android.app.ui.screen.home

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.wearperfect.android.app.component.appbar.PerfectBottomNavigationAppBar
import com.wearperfect.android.app.constant.navigation.BottomNavigationDestination
import com.wearperfect.android.app.navigation.BottomNavigationHost

@Composable
fun HomeScreen(
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