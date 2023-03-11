package com.wearperfect.android.app.component.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PerfectButtonText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text
    )
}