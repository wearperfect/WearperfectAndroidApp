package com.wearperfect.android.app.component.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun PerfectSubTitleText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        fontWeight = FontWeight.Light
    )
}