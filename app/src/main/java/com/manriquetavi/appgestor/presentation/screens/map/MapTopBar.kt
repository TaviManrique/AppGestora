package com.manriquetavi.appgestor.presentation.screens.map

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.manriquetavi.appgestor.ui.theme.topAppBarBackgroundColor

@Composable
fun MapTopBar(navController: NavHostController) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.clickable { navController.popBackStack() },
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Icon Back"
                )
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = "Mapa"
                )
            }
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
    )
}
