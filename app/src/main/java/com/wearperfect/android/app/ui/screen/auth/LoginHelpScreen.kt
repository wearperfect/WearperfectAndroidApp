package com.wearperfect.android.app.ui.screen.auth

import androidx.compose.runtime.Composable
import com.wearperfect.android.app.component.appbar.PerfectTopAppBar
import com.wearperfect.android.app.component.scaffold.PerfectScaffold
import com.wearperfect.android.app.component.text.HeaderText

@Composable
fun LoginHelpScreen(
    navigateToLogIn: () -> Unit
){
    PerfectScaffold(
        topBar = {
            PerfectTopAppBar(
                title = { HeaderText(text = "Log in help") },
            )
        }
    ) {

    }
}