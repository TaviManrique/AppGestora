package com.manriquetavi.appgestor.presentation.screens.report

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.manriquetavi.appgestor.domain.model.Product
import com.manriquetavi.appgestor.domain.model.Response
import com.manriquetavi.appgestor.presentation.components.ProductItem
import com.manriquetavi.appgestor.presentation.components.ProgressBar
import com.manriquetavi.appgestor.ui.theme.MediumGray
import com.manriquetavi.appgestor.ui.theme.topAppBarBackgroundColor
import com.manriquetavi.appgestor.util.Util
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun ReportScreen(
    navController: NavHostController,
    reportViewModel: ReportViewModel = hiltViewModel()
) {
    val productsResponse = reportViewModel.productsState.value

    Scaffold(
        topBar = {
            ReportTopBar(
                navController = navController,
                onSaveClicked = {}
            )
        }
    ) {
        when (productsResponse) {
            is Response.Loading -> ProgressBar()
            is Response.Success -> ReportContent(products = productsResponse.data)
            is Response.Error -> Util.printError(productsResponse.message)
        }
    }
}

@Composable
fun ReportContent(products: List<Product?>) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier.padding(16.dp),
            text = "Reporte de Precios",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 50.dp,
                    bottom = 8.dp,
                    start = 8.dp,
                    end = 8.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .height(48.dp)
                    .weight(0.4f)
                    .background(MediumGray)
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = RectangleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Productos",
                    textAlign = TextAlign.Center,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Box(
                modifier = Modifier
                    .height(48.dp)
                    .weight(0.2f)
                    .background(MediumGray)
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = RectangleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "P. Costo",
                    textAlign = TextAlign.Center,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Box(
                modifier = Modifier
                    .height(48.dp)
                    .weight(0.2f)
                    .background(MediumGray)
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = RectangleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text= "P. Costo x Mayor",
                    textAlign = TextAlign.Center,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        LazyColumn {
            itemsIndexed(products) { _, product ->
                product?.let { ProductItem(product = it) }
            }
        }
    }
}


@ExperimentalCoroutinesApi
@Preview(showBackground = true)
@Composable
fun ReportScreenPreview() {
    ReportContent(emptyList())
}
