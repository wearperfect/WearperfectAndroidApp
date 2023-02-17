package com.wearperfect.android.app.component.input


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.wearperfect.android.app.component.button.PerfectIconButton
import com.wearperfect.android.app.component.text.CaptionErrorText

@Composable
fun PerfectTextInput(
    modifier: Modifier = Modifier,
    singleLine: Boolean = true,
    label: String,
    valueState: MutableState<String>,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isPasswordField: Boolean = false,
    showError: Boolean = false,
    errorText: String = "",
    showSuccess: Boolean = false,
    successText: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    onValueChange: (String) -> Unit,
) {
    var passwordVisibility = remember {
        mutableStateOf(false)
    }

    val passwordVisibilityIcon = if (passwordVisibility.value) {
        Icons.Default.Visibility
    } else {
        Icons.Default.VisibilityOff
    }

    Column(

    ) {
        OutlinedTextField(
            modifier = modifier.height(60.dp),
            singleLine = singleLine,
            label = { Text(text = label) },
            value = valueState.value,
            onValueChange = { value ->
                run {
                    valueState.value = value
                    onValueChange(value)
                }
            },
            enabled = enabled,
            readOnly = readOnly,
            placeholder = placeholder,
            leadingIcon = leadingIcon,
            trailingIcon = {
                when {
                    (showError && !isPasswordField) -> PerfectIconButton(
                        imageVector = Icons.Default.Error,
                        contentDescription = "Error Icon"
                    ) { passwordVisibility.value = !passwordVisibility.value }
                    (isPasswordField) -> PerfectIconButton(
                        imageVector = passwordVisibilityIcon,
                        contentDescription = "Password Visibility Toggle Icon"
                    ) { passwordVisibility.value = !passwordVisibility.value }
                    else -> {}
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType, imeAction = imeAction
            ),
            keyboardActions = keyboardActions,
            visualTransformation =
            when {
                (showError && !isPasswordField) -> VisualTransformation.None
                (isPasswordField) ->
                    if (passwordVisibility.value) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    }
                else -> VisualTransformation.None
            }
        )
        if (showError) {
            CaptionErrorText(
                text = errorText,
            )
        }
        if (showSuccess) {
            CaptionErrorText(
                text = successText,
            )
        }
    }
}