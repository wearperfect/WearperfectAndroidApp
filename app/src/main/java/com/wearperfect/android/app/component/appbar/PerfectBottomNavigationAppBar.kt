package com.wearperfect.android.app.component.appbar

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.wearperfect.android.app.component.draw.drawTopBorder
import com.wearperfect.android.app.constant.navigation.BottomNavigationDestination

@Composable
fun PerfectBottomNavigationAppBar(
    navController: NavHostController,
    destinations: List<BottomNavigationDestination>
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        modifier = Modifier.drawBehind { this.drawTopBorder(strokeWidth = 1, color = Color.DarkGray) },
        backgroundColor = MaterialTheme.colors.background,
    ) {
        destinations.forEach { destination ->
            BottomNavigationItem(
                //label = { Text(text = destination.title) },
                icon = { Icon(imageVector = destination.icon, contentDescription = destination.title) },
                unselectedContentColor =  LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
                selected = currentDestination?.hierarchy?.any {
                    it.route == destination.route
                } == true,
                onClick = {
                    navController.navigate(destination.route){
                        popUpToRoute
                        launchSingleTop = true
                    }
                }
            )
        }
    }

}