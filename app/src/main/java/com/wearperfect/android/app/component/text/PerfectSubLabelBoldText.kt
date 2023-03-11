package com.wearperfect.android.app.component.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun PerfectSubLabelBoldText(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Ellipsis
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.caption,
        fontWeight = FontWeight.Bold,
        maxLines = maxLines,
        overflow = overflow
    )
}