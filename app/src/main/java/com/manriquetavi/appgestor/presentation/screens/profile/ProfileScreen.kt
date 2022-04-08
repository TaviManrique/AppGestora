package com.manriquetavi.appgestor.presentation.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.manriquetavi.appgestor.R
import com.manriquetavi.appgestor.ui.theme.topAppBarBackgroundColor

@Composable
fun ProfileScreen(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            ProfileTopBar(
                navController = navController
            ) {
                signOff(navController)
            }
        }
    ) {
        ContentProfileScreen()
    }
}

fun signOff(navController: NavHostController) {
    navController.popBackStack()
}

@Composable
fun ContentProfileScreen() {
    Column(
        modifier = Modifier.
        fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .border(
                    width = 4.dp,
                    color = MaterialTheme.colors.topAppBarBackgroundColor,
                    shape = CircleShape
                ),
            painter = painterResource(id = R.drawable.img_user),
            contentDescription = "Circular Image Profile"
        )
        Text(
            modifier = Modifier.padding(vertical = 16.dp),
            text = "Tavi Manrique",
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            modifier = Modifier.padding(vertical = 16.dp),
            text = "tavidanner96@gmail.com",
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}
