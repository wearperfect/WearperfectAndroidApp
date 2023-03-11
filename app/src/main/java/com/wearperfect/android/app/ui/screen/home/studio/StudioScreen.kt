package com.wearperfect.android.app.ui.screen.home.studio

import android.util.Log
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.wearperfect.android.app.component.appbar.PerfectTopAppBar
import com.wearperfect.android.app.component.draw.drawBottomBorder
import com.wearperfect.android.app.component.scaffold.PerfectScaffold
import com.wearperfect.android.app.component.text.PerfectHeaderText

@Composable
fun StudioScreen(navController: NavHostController) {
    PerfectScaffold(
        topBar = {
            PerfectTopAppBar(
                title = { PerfectHeaderText("Studio") },
                backgroundColor = MaterialTheme.colors.background,
                contentColor = MaterialTheme.colors.onBackground,
                modifier = Modifier.drawBehind {
                    this.drawBottomBorder(
                        strokeWidth = 1,
                        color = Color.Transparent
                    )
                },
            )
        }
    ) {
        Log.i("TAG", "StudioScreen: $it")
    }
}