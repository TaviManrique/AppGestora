package com.manriquetavi.appgestor.presentation.screens.visit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.manriquetavi.appgestor.ui.theme.topAppBarBackgroundColor
import com.manriquetavi.appgestor.ui.theme.topAppBarContentColor

@Composable
fun VisitTopBar(
    navController: NavHostController
) {
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
                    text = "Visita"
                )
            }
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )
}