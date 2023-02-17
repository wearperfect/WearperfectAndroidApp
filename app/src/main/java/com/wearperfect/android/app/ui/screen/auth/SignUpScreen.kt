package com.wearperfect.android.app.ui.screen.auth

import android.util.Log
import android.util.Patterns
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
import com.wearperfect.android.app.data.model.AccessToken
import com.wearperfect.android.app.data.model.UserRegistrationData
import com.wearperfect.android.app.ui.viewmodel.AccountViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignUpScreen(
    navigateToLogIn: () -> Unit,
    navigateToMain: () -> Unit,
    accountViewModel: AccountViewModel = hiltViewModel(),
) {
    val signUpState by accountViewModel.signUpStateFlow.collectAsState()
    val logInState by accountViewModel.logInStateFlow.collectAsState()

    LaunchedEffect(key1 = logInState){
        accountViewModel.verifyLogin()
    }

    LaunchedEffect(key1 = logInState, block = {
        if(logInState is RequestState.Success<Boolean>){
            if ((logInState as RequestState.Success<Boolean>).data) {
                navigateToMain()
            }
        }
    })

    val emailOrPhoneState = remember {  mutableStateOf("") }
    val fullnameState = remember { mutableStateOf("") }
    val usernameState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    var isEmailOrPhoneValid by remember {  mutableStateOf(true) }
    var isUsernameValid by remember {  mutableStateOf(true) }
    var isPasswordValid by remember {  mutableStateOf(true) }

    fun validateSignUpData(): Boolean {
        val usernameRegex = "^[a-zA-Z0-9_]{3,16}\$".toRegex()
        val passwordRegex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\\s).{8,15}\$".toRegex()

        isEmailOrPhoneValid = Patterns.PHONE.matcher(emailOrPhoneState.value)
            .matches() || Patterns.EMAIL_ADDRESS.matcher(emailOrPhoneState.value).matches()
        isUsernameValid = usernameRegex.matches(usernameState.value)
        isPasswordValid = passwordRegex.matches(passwordState.value)

        return isEmailOrPhoneValid && isUsernameValid && isPasswordValid
    }

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    fun register(){
        if(validateSignUpData()){
            Log.i("SignUpScreen", "register: Success")
        }else {
            Log.i("SignUpScreen", "register: Failure")
        }
        keyboardController?.hide()
        var phone: String? = null
        var email: String? = null

        if (Patterns.PHONE.matcher(emailOrPhoneState.value).matches()){
            phone = emailOrPhoneState.value
        } else if (Patterns.EMAIL_ADDRESS.matcher(emailOrPhoneState.value).matches()){
            email = emailOrPhoneState.value
        }
        accountViewModel.registerUser(
            UserRegistrationData(
                username = usernameState.value,
                password = passwordState.value,
                fullname = fullnameState.value,
                phone =  phone,
                email = email
            )
        )
    }

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
                    valueState = emailOrPhoneState,
                    onValueChange = { value -> emailOrPhoneState.value = value.trim() },
                    label = "Email or Phone",
                    singleLine = true,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    keyboardActions = KeyboardActions(
                        onNext = {focusManager.moveFocus(FocusDirection.Down)}
                    ),
                    enabled = signUpState is RequestState.Idle,
                    showError = !isEmailOrPhoneValid,
                    errorText = "Invalid Email or Phone"
                )
                Spacer(
                    modifier = Modifier.size(12.dp)
                )
                PerfectTextInput(
                    modifier = Modifier.fillMaxWidth(),
                    valueState = fullnameState,
                    onValueChange = { value -> fullnameState.value = value },
                    label = "Full Name",
                    singleLine = true,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    keyboardActions = KeyboardActions(
                        onNext = {focusManager.moveFocus(FocusDirection.Down)}
                    ),
                    enabled = signUpState is RequestState.Idle,
                )
                Spacer(
                    modifier = Modifier.size(12.dp)
                )
                PerfectTextInput(
                    modifier = Modifier.fillMaxWidth(),
                    valueState = usernameState,
                    onValueChange = { value -> usernameState.value = value.trim() },
                    label = "Username",
                    singleLine = true,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    keyboardActions = KeyboardActions(
                        onNext = {focusManager.moveFocus(FocusDirection.Down)}
                    ),
                    enabled = signUpState is RequestState.Idle,
                    showError = !isUsernameValid,
                    errorText = "Invalid Username"
                )
                Spacer(
                    modifier = Modifier.size(12.dp)
                )
                PerfectTextInput(
                    modifier = Modifier.fillMaxWidth(),
                    valueState = passwordState,
                    onValueChange = { value -> passwordState.value = value.trim() },
                    label = "Password",
                    singleLine = true,
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done,
                    keyboardActions = KeyboardActions(
                        onDone = {focusManager.clearFocus()}
                    ),
                    enabled = signUpState is RequestState.Idle,
                    showError = !isPasswordValid,
                    errorText = "Invalid Password",
                    isPasswordField = true
                )
                Spacer(
                    modifier = Modifier.size(12.dp)
                )
                PerfectButton(
                    modifier = Modifier.fillMaxWidth(),
                    enabled = signUpState is RequestState.Idle,
                    onClick = { register() }
                ) {
                    if(signUpState is RequestState.Loading || signUpState is RequestState.Success<AccessToken>){
                        ButtonText(text = "Signing up...")
                    } else {
                        ButtonText(text = "Sign up")
                    }
                }
                Spacer(
                    modifier = Modifier.size(12.dp)
                )
                HelperText(
                    queryText = "Already have an account? ",
                    helpText = "Log in.",
                    onClick = { navigateToLogIn() }
                )
            }
        }
    }
}