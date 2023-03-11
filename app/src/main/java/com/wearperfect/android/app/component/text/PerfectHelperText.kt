package com.wearperfect.android.app.component.text

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun PerfectHelperText(
    queryText: String,
    helpText: String,
    queryTextModifier: Modifier = Modifier,
    helpTextModifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row() {
        Text(
            modifier = queryTextModifier,
            fontSize = MaterialTheme.typography.subtitle2.fontSize,
            text = queryText
        )
        Text(
            modifier = helpTextModifier.clickable {
                onClick.invoke()
            },
            fontSize = MaterialTheme.typography.subtitle2.fontSize,
            fontWeight = FontWeight.Bold,
            text = helpText
        )
    }
}