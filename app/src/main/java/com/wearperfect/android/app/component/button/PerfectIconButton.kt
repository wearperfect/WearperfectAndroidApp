package com.wearperfect.android.app.component.button

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun PerfectIconButton(
    imageVector: ImageVector,
    contentDescription: String,
    tint: Color = MaterialTheme.colors.onBackground,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
){
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription,
            tint = tint
        )
    }
}