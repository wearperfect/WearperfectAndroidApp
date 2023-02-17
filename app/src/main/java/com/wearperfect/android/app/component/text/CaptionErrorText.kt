package com.wearperfect.android.app.component.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun CaptionErrorText(
    text: String,
    modifier: Modifier = Modifier
){
    Text(
        modifier = modifier,
        style = MaterialTheme.typography.caption,
        color = Color.Red,
        text = text
    )
}