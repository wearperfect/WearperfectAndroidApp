package com.wearperfect.android.app.constant.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationDestination(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Feed: BottomNavigationDestination(
        route = Destination.FEED_SCREEN.route,
        title = Destination.FEED_SCREEN.title,
        icon = Icons.Default.LibraryBooks
    )
    object Explore: BottomNavigationDestination(
        route = Destination.EXPLORE_SCREEN.route,
        title = Destination.EXPLORE_SCREEN.title,
        icon = Icons.Default.Explore
    )
    object Studio: BottomNavigationDestination(
        route = Destination.STUDIO_SCREEN.route,
        title = Destination.STUDIO_SCREEN.title,
        icon = Icons.Default.MovieFilter
    )
    object Store: BottomNavigationDestination(
        route = Destination.STORE_SCREEN.route,
        title = Destination.STORE_SCREEN.title,
        icon = Icons.Default.Store
    )
    object Profile: BottomNavigationDestination(
        route = Destination.PROFILE_SCREEN.route,
        title = Destination.PROFILE_SCREEN.title,
        icon = Icons.Default.Person
    )
}