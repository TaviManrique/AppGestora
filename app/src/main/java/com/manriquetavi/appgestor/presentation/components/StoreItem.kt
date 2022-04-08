package com.manriquetavi.appgestor.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.manriquetavi.appgestor.R
import com.manriquetavi.appgestor.domain.model.Store
import com.manriquetavi.appgestor.navigation.Screen

@Composable
fun StoreItem(
    store: Store,
    navController: NavHostController,
) {
    Card(
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()
            .clickable {  },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 4.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(10.dp)
                    .size(80.dp)
                    .clickable {
                        navController.navigate(
                            Screen.Map.passLatitudeAndLongitude(
                                latitude = store.latitude.toDouble(),
                                longitude = store.longitude.toDouble()
                            )
                        )
                    },
                shape = RectangleShape,
                elevation = 4.dp
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_map),
                    contentDescription = "Google Map Image"
                )
            }
            Column(
                modifier = Modifier.padding(4.dp)
            ) {
                Text(
                    text = store.name,
                    style = MaterialTheme.typography.h6,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Codigo: ${store.code}",
                    style = MaterialTheme.typography.caption,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = store.address,
                    style = MaterialTheme.typography.caption,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}