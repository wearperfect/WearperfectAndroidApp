package com.wearperfect.android.app.component.input


import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
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

@Composable
fun PerfectPasswordTextInput(
    modifier: Modifier = Modifier,
    singleLine: Boolean = true,
    label: String,
    valueState: MutableState<String>,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    onValueChange: (String) -> Unit
) {

    var passwordVisibility = remember {
        mutableStateOf(false)
    }

    val passwordVisibilityIcon =  if(passwordVisibility.value) {
        Icons.Default.Visibility
    } else{
        Icons.Default.VisibilityOff
    }

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
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType, imeAction = imeAction
        ),
        keyboardActions = keyboardActions,
        trailingIcon = {
            IconButton(onClick = { passwordVisibility.value = !passwordVisibility.value  }) {
                Icon(imageVector = passwordVisibilityIcon, contentDescription = "Password Visibility Toggle Icon")
            }
        },
        visualTransformation = if (passwordVisibility.value)
            VisualTransformation.None
        else
            PasswordVisualTransformation()
    )
}