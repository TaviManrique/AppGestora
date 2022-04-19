package com.manriquetavi.appgestor.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.manriquetavi.appgestor.domain.model.Product
import com.manriquetavi.appgestor.ui.theme.LightGray
import com.manriquetavi.appgestor.ui.theme.topAppBarBackgroundColor

@Composable
fun ProductItem(
    product: Product
) {
    Row(
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(0.4f)
                .background(LightGray)
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RectangleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = product.name.toString(),
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
        Box(
            modifier = Modifier
                .weight(0.2f)
                .background(LightGray)
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RectangleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = product.salePrice.toString(),
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
        Box(
            modifier = Modifier
                .weight(0.2f)
                .background(LightGray)
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RectangleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text= product.wholesalePrice.toString(),
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}