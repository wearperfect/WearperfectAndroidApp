package com.wearperfect.android.app.ui.screen.home.profile

import android.util.Log
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.wearperfect.android.app.component.appbar.PerfectTopAppBar
import com.wearperfect.android.app.component.button.PerfectIconButton
import com.wearperfect.android.app.component.draw.drawBottomBorder
import com.wearperfect.android.app.component.scaffold.PerfectScaffold
import com.wearperfect.android.app.component.text.HeaderText
import com.wearperfect.android.app.constant.navigation.Destination
import com.wearperfect.android.app.constant.network.RequestState
import com.wearperfect.android.app.ui.viewmodel.AccountViewModel

@Composable
fun ProfileScreen(
    navController: NavHostController,
    accountViewModel: AccountViewModel = hiltViewModel(),
    navigateToLogin: () -> Unit
) {

    val logInState by accountViewModel.logInStateFlow.collectAsState()

    LaunchedEffect(key1 = true){
        accountViewModel.verifyLogin()
    }

    LaunchedEffect(key1 = logInState){
        if(logInState is RequestState.Success<Boolean>){
            val isLoggedIn = (logInState as RequestState.Success<Boolean>).data
            if(!isLoggedIn){
                navigateToLogin()
            }
        }
    }

    PerfectScaffold(
        topBar = {
            PerfectTopAppBar(
                title = { HeaderText("Profile") },
                backgroundColor = MaterialTheme.colors.background,
                contentColor = MaterialTheme.colors.onBackground,
                modifier = Modifier.drawBehind {
                    this.drawBottomBorder(
                        strokeWidth = 1,
                        color = Color.Transparent
                    )
                },
                actions = {
                    ProfileTopAppBarActions(
                        accountViewModel = accountViewModel
                    )
                }
            )
        }
    ) {
        Log.i("TAG", "ProfileScreen: $it")
    }
}

@Composable
fun ProfileTopAppBarActions(
    accountViewModel: AccountViewModel
) {
    PerfectIconButton(
        imageVector = Icons.Default.Logout,
        contentDescription = "Add Icon"
    ) {
        accountViewModel.logoutUser()
    }
}