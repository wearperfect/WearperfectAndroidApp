package com.wearperfect.android.app.ui.screen.home.explore

import android.util.Log
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.Search
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
fun ExploreScreen(navController: NavHostController) {
    PerfectScaffold(
        topBar = {
            PerfectTopAppBar(
                title = { HeaderText(text = "Explore") },
                backgroundColor = MaterialTheme.colors.background,
                contentColor = MaterialTheme.colors.onBackground,
                actions = { ExploreTopAppBarActions(navController) },
                modifier = Modifier.drawBehind {
                    this.drawBottomBorder(
                        strokeWidth = 1,
                        color = Color.Transparent
                    )
                },
            )
        }
    ) {
        Log.i("TAG", "ExploreScreen: $it")
    }
}

@Composable
fun ExploreTopAppBarActions(navController: NavHostController) {
    PerfectIconButton(
        imageVector = Icons.Default.Search,
        contentDescription = "Search Icon"
    ) {

    }
    PerfectIconButton(
        imageVector = Icons.Default.FilterAlt,
        contentDescription = "Filter Icon"
    ) {

    }
    PerfectIconButton(
        imageVector = Icons.Default.AutoAwesome,
        contentDescription = "Preferences Icon"
    ) {

    }
}