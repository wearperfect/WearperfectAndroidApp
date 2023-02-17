package com.wearperfect.android.app.ui.screen.home.store

import android.util.Log
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.wearperfect.android.app.component.appbar.PerfectTopAppBar
import com.wearperfect.android.app.component.button.PerfectIconButton
import com.wearperfect.android.app.component.draw.drawBottomBorder
import com.wearperfect.android.app.component.scaffold.PerfectScaffold
import com.wearperfect.android.app.component.text.HeaderText

@Composable
fun StoreScreen(navController: NavHostController) {
    PerfectScaffold(
        topBar = {
            PerfectTopAppBar(
                title = { HeaderText(text = "Store") },
                backgroundColor = MaterialTheme.colors.background,
                contentColor = MaterialTheme.colors.onBackground,
                actions = { StoreTopAppBarActions(navController) },
                modifier = Modifier.drawBehind {
                    this.drawBottomBorder(
                        strokeWidth = 1,
                        color = Color.Transparent
                    )
                },
            )
        }
    ) {
        Log.i("TAG", "StoreScreen: $it")
        StoreScreenContent(navController = navController)
    }
}

@Composable
fun StoreTopAppBarActions(navController: NavHostController) {
    PerfectIconButton(
        imageVector = Icons.Outlined.Search,
        contentDescription = "Search Icon"
    ) {

    }
    PerfectIconButton(
        imageVector = Icons.Outlined.FilterAlt,
        contentDescription = "Filter Icon"
    ) {

    }
    PerfectIconButton(
        imageVector = Icons.Outlined.FavoriteBorder,
        contentDescription = "Favorite Icon"
    ) {

    }
    PerfectIconButton(
        imageVector = Icons.Outlined.ShoppingBag,
        contentDescription = "Shopping Bag Icon"
    ) {

    }
}