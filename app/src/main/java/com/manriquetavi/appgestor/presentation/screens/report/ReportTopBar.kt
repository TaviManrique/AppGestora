package com.manriquetavi.appgestor.presentation.screens.report

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ReportTopBar(
    navController: NavHostController,
    onSaveClicked: () -> Unit
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
                    text = "Reporte"
                )
            }
        },
        actions = {
            IconButton(onClick = onSaveClicked) {
                Icon(
                    imageVector = Icons.Default.Save,
                    contentDescription = "Save Icon"
                )
            }
        }
    )
}