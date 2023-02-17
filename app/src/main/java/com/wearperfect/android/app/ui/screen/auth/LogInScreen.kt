package com.wearperfect.android.app.ui.screen.auth

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.wearperfect.android.app.component.button.PerfectButton
import com.wearperfect.android.app.component.input.PerfectTextInput
import com.wearperfect.android.app.component.scaffold.PerfectScaffold
import com.wearperfect.android.app.component.text.ButtonText
import com.wearperfect.android.app.component.text.HelperText
import com.wearperfect.android.app.component.text.SubTitleText
import com.wearperfect.android.app.component.text.TitleText
import com.wearperfect.android.app.constant.network.RequestState
import com.wearperfect.android.app.data.model.UserCredential
import com.wearperfect.android.app.ui.viewmodel.AccountViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LogInScreen(
    navigateToLogInHelp: () -> Unit,
    navigateToSignUp: () -> Unit,
    navigateToMain: () -> Unit,
    accountViewModel: AccountViewModel = hiltViewModel()
) {
    val logInState by accountViewModel.logInStateFlow.collectAsState()

    LaunchedEffect(key1 = logInState){
        accountViewModel.verifyLogin()
    }

    LaunchedEffect(key1 = logInState, block = {
        if(logInState is RequestState.Success<Boolean>){
            Log.i("LogInScreen", "LogInScreen LaunchedEffect: isLoggedIn: ${(logInState as RequestState.Success<Boolean>)}")
            if ((logInState as RequestState.Success<Boolean>).data) {
                navigateToMain()
            }
        }
    })

    val inputEnabled = remember(logInState) {
        when (logInState) {
            is RequestState.Idle -> true
            is RequestState.Loading -> false
            is RequestState.Success<Boolean> -> !(logInState as RequestState.Success<Boolean>).data
            is RequestState.Error -> true
        }
    }

    val usernameState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    PerfectScaffold {
        Log.i("TAG", "LogInScreen: $it")
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
            ) {
                TitleText(text = "Wearperfect")
                SubTitleText(text = "Let your style do the talking.")
                Spacer(
                    modifier = Modifier.size(20.dp)
                )
                PerfectTextInput(
                    modifier = Modifier.fillMaxWidth(),
                    valueState = usernameState,
                    onValueChange = { value -> usernameState.value = value },
                    label = "Username",
                    singleLine = true,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    keyboardActions = KeyboardActions(
                        onNext = {focusManager.moveFocus(FocusDirection.Down)}
                    ),
                    enabled = inputEnabled,
                )
                Spacer(
                    modifier = Modifier.size(12.dp)
                )
                PerfectTextInput(
                    modifier = Modifier.fillMaxWidth(),
                    valueState = passwordState,
                    onValueChange = { value -> passwordState.value = value },
                    label = "Password",
                    singleLine = true,
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done,
                    keyboardActions = KeyboardActions(
                        onDone = {focusManager.clearFocus()}
                    ),
                    enabled = inputEnabled,
                    isPasswordField = true
                )
                Spacer(
                    modifier = Modifier.size(12.dp)
                )
                PerfectButton(
                    modifier = Modifier.fillMaxWidth(),
                    enabled = inputEnabled,
                    onClick = {
                        keyboardController?.hide()
                        accountViewModel.authenticateUser(
                            UserCredential(
                                usernameState.value.trim(),
                                passwordState.value.trim()
                            )
                        )
                    }
                ) {
                    if(inputEnabled){
                        ButtonText(text = "Log in")
                    } else {
                        ButtonText(text = "Logging in...")
                    }
                }
                Spacer(
                    modifier = Modifier.size(12.dp)
                )
                HelperText(
                    queryText = "Forgot your login details? ",
                    helpText = "Get help.",
                    onClick = { navigateToLogInHelp() }
                )
                Spacer(
                    modifier = Modifier.size(8.dp)
                )
                HelperText(
                    queryText = "Don't have an account? ",
                    helpText = "Sign up.",
                    onClick = { navigateToSignUp() }
                )
            }
        }
    }
}