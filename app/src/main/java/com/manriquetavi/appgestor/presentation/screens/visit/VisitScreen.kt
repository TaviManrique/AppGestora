package com.manriquetavi.appgestor.presentation.screens.visit

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow

import androidx.compose.ui.unit.dp

import androidx.navigation.NavHostController

import com.manriquetavi.appgestor.R

import com.manriquetavi.appgestor.navigation.Screen
import kotlin.math.log

@Composable
fun VisitScreen(
    navController: NavHostController
) {
    val storeName = navController.currentBackStackEntry?.arguments?.getString("storeName")
    val storeAddress = navController.currentBackStackEntry?.arguments?.getString("storeAddress")
    val storeId = navController.currentBackStackEntry?.arguments?.getString("storeId")

    Scaffold(
        topBar = { VisitTopBar(navController = navController ) }
    ) {
        storeId?.let { storeId ->
            ContentVisitScreen(
                navController = navController,
                storeName = storeName,
                storeAddress = storeAddress,
                storeId = storeId
            )
        }
    }
}

@Composable
fun ContentVisitScreen(navController: NavHostController, storeName: String?, storeAddress: String?, storeId: String) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        //Store Name
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = storeName.toString(),
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        //Store Address
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = storeAddress.toString(),
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )

        Image(
            modifier = Modifier
                .size(160.dp)
                .padding(vertical = 20.dp),
            painter = painterResource(id = R.drawable.img_map),
            contentDescription = "Image Store"
        )
        Button(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 60.dp)
                .fillMaxWidth(),
            onClick = { navController.navigate(Screen.Report.passStoreIdToReport(storeId = storeId)) },
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Visitar"
            )
        }
    }
}
