package com.wearperfect.android.app.component.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun PerfectHeaderText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = MaterialTheme.typography.h5.fontSize,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colors.onBackground
    )
}