package com.wearperfect.android.app.component.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.wearperfect.android.app.component.button.PerfectButton
import com.wearperfect.android.app.component.text.PerfectButtonText
import com.wearperfect.android.app.component.text.PerfectSubTitleText
import com.wearperfect.android.app.component.text.PerfectTitleText

@Composable
fun PerfectBannerCard(
    mediaUrl: String = "https://weraperfect-banners.s3.ap-south-1.amazonaws.com/summer+sale+discount+banner.jpeg",
    title: String = "Summer is coming!",
    description: String = "Beat the heat with these cool products...",
    action: () -> Unit
){
    Column() {
        Image(
            painter = rememberAsyncImagePainter(mediaUrl),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.3f)
                .clip(shape = RoundedCornerShape(4.dp))
        )
        PerfectTitleText(text = title)
        PerfectSubTitleText(text = description)
        PerfectButton(onClick = action) {
            PerfectButtonText(text = "Get them!")
        }
    }
}