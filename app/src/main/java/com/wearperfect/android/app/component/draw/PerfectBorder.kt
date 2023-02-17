package com.wearperfect.android.app.component.draw

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp

fun DrawScope.drawBottomBorder(strokeWidth: Int = 1, color: Color) = drawLine(
        color = color,
        start = Offset(0f, size.height),
        end = Offset(size.width, size.height),
        strokeWidth = strokeWidth.dp.toPx()
    )

fun DrawScope.drawTopBorder(strokeWidth: Int = 1, color: Color) = drawLine(
    color = color,
    start = Offset(0f, 0f),
    end = Offset(size.width, 0f),
    strokeWidth = strokeWidth.dp.toPx()
)