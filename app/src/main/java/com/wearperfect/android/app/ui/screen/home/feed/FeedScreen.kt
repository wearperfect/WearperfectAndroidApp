package com.wearperfect.android.app.ui.screen.home.feed

import android.util.Log
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddBox
import androidx.compose.material.icons.outlined.Chat
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
import com.wearperfect.android.app.constant.network.RequestState
import com.wearperfect.android.app.data.model.User
import com.wearperfect.android.app.ui.viewmodel.AccountViewModel
import com.wearperfect.android.app.ui.viewmodel.FeedViewModel
import com.wearperfect.android.app.ui.viewmodel.UserDetailsViewModel

@Composable
fun FeedScreen(
    navController: NavHostController,
    accountViewModel: AccountViewModel = hiltViewModel(),
    feedViewModel: FeedViewModel = hiltViewModel(),
    userDetailsViewModel: UserDetailsViewModel = hiltViewModel()
) {

    val loggedInUserDetails by userDetailsViewModel.loggedInUserDetails.collectAsState()
    val logInState by accountViewModel.logInStateFlow.collectAsState()

    LaunchedEffect(key1 = true) {
        accountViewModel.verifyLogin()
    }

    LaunchedEffect(key1 = logInState) {
        if (logInState is RequestState.Success<Boolean>) {
            if ((logInState as RequestState.Success<Boolean>).data) {
                userDetailsViewModel.getLoggedInUserDetails()
            }
        }
    }

    PerfectScaffold(
        topBar = {
            PerfectTopAppBar(
                title = { HeaderText(text = "Feed") },
                actions = { FeedTopAppBarActions(navController) },
                modifier = Modifier.drawBehind {
                    this.drawBottomBorder(
                        strokeWidth = 1,
                        color = Color.Transparent
                    )
                },
            )
        }
    ) {
        Log.i("TAG", "FeedScreen: $it")
        if (loggedInUserDetails is RequestState.Success<User>) {
            val userDetails = loggedInUserDetails as RequestState.Success<User>
            Text(text = userDetails.data.username)
        }
    }
}

@Composable
fun FeedTopAppBarActions(navController: NavHostController) {
    PerfectIconButton(
        imageVector = Icons.Outlined.AddBox,
        contentDescription = "Add Icon"
    ) {

    }
    PerfectIconButton(
        imageVector = Icons.Outlined.Chat,
        contentDescription = "Chat Icon"
    ) {

    }
}