package com.wearperfect.android.app.component.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun PerfectLabelText(
    text: String,
    color: Color = MaterialTheme.colors.onBackground,
    modifier: Modifier = Modifier,
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Ellipsis
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        style = MaterialTheme.typography.body2,
        fontWeight = FontWeight.Bold,
        maxLines = maxLines,
        overflow = overflow
    )
}