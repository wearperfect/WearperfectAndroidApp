package com.wearperfect.android.app.component.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun PerfectTitleText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.h3,
        fontWeight = FontWeight.Light
    )
}