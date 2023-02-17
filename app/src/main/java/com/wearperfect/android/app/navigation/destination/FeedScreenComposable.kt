package com.wearperfect.android.app.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.wearperfect.android.app.constant.navigation.Destination
import com.wearperfect.android.app.ui.screen.home.feed.FeedScreen

fun NavGraphBuilder.feedScreenComposable(navController: NavHostController){

    composable(
        route = Destination.FEED_SCREEN.route
    ){
        FeedScreen(navController)
    }
}