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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.manriquetavi.appgestor.R
import com.manriquetavi.appgestor.navigation.Screen

@Composable
fun VisitScreen(
    navController: NavHostController
) {
    val storeId = navController.currentBackStackEntry?.arguments?.getInt("storeId")

    Scaffold(
        topBar = { VisitTopBar(navController = navController ) }
    ) {
        storeId?.let { storeId ->
            ContentVisitScreen(
                navController = navController,
                storeId = storeId
            )
        }
    }
}

@Composable
fun ContentVisitScreen(navController: NavHostController, storeId: Int) {
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
            text = "Name Name Name Name Name Name Name Name Name Name",
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        //Store Address
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = "Address Address Address Address Address Address",
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

@Preview(showBackground = true)
@Composable
fun ContentVisitScreenPreview() {
    ContentVisitScreen(navController = rememberNavController(), 1)
}
