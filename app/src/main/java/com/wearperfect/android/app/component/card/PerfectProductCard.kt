package com.wearperfect.android.app.component.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.wearperfect.android.app.component.button.PerfectIconButton
import com.wearperfect.android.app.component.text.PerfectLabelText
import com.wearperfect.android.app.component.text.PerfectSubLabelBoldText
import com.wearperfect.android.app.component.text.PerfectSubLabelText
import com.wearperfect.android.app.data.dto.ProductDTO

@Composable
fun PerfectProductCard(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.small,
    backgroundColor: Color = MaterialTheme.colors.background,
    contentColor: Color = MaterialTheme.colors.onBackground,
    border: BorderStroke? = null,
    elevation: Dp = 0.dp,
    product: ProductDTO
) {
    Card(
        modifier = modifier.padding(8.dp),
        shape = shape,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        border = border,
        elevation = elevation
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            if (product.productMediaList.isNotEmpty()) {
                Image(
                    painter = rememberAsyncImagePainter(product.productMediaList[0].sourceLink),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .clip(shape = RoundedCornerShape(4.dp))
                )
            }
            Column(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            ) {
                Row() {
                    PerfectLabelText(
                        modifier = Modifier.weight(0.80f),
                        text = product.manufacturer.fullname,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.weight(0.05f))
                    PerfectIconButton( // Switch to Icon component
                        modifier = Modifier
                            .size(20.dp)
                            .padding(0.dp)
                            .weight(0.15f),
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = "Favorite Icon"
                    ) { }
                }
                Spacer(modifier = modifier.height(1.dp))
                PerfectSubLabelText(
                    text = product.name, maxLines = 2, overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row() {
                    PerfectSubLabelBoldText(
                        text = "$${product.price}", maxLines = 2, overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}