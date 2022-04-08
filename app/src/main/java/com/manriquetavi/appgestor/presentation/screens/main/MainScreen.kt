package com.manriquetavi.appgestor.presentation.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.manriquetavi.appgestor.R
import com.manriquetavi.appgestor.domain.model.Product
import com.manriquetavi.appgestor.domain.model.Store
import com.manriquetavi.appgestor.navigation.Screen
import com.manriquetavi.appgestor.presentation.components.AlertDialogScreen
import com.manriquetavi.appgestor.ui.theme.SMALL_PADDING

@Composable
fun MainScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    /*
    val stores = listOf(
        Store(
            id = 1,
            name = "Plaza Vea",
            code = 1001,
            address = "C. Lima 123",
            latitude = -12.115225,
            longitude = -76.9928401,
            products = listOf(
                Product(
                    name = "Casaca Tienda 1",
                    salePrice = 10.50,
                    wholesalePrice = 8.25
                ),
                Product(
                    name = "Polo Tienda 1",
                    salePrice = 10.50,
                    wholesalePrice = 8.25
                ),
                Product(
                    name = "Zapatilla Tienda 1",
                    salePrice = 10.50,
                    wholesalePrice = 8.25
                )
            )
        ),
        Store(
            id = 2,
            name = "Metro",
            code = 1002,
            address = "Av. Javier Prado 2345",
            latitude = -12.0826094,
            longitude = -77.0361253,
            products = listOf(
                Product(
                    name = "Casaca Tienda 2",
                    salePrice = 10.50,
                    wholesalePrice = 8.25
                ),
                Product(
                    name = "Polo Tienda 2",
                    salePrice = 10.50,
                    wholesalePrice = 8.25
                ),
                Product(
                    name = "Zapatilla Tienda 2",
                    salePrice = 10.50,
                    wholesalePrice = 8.25
                )
            )
        ),
        Store(
            id = 3,
            name = "Wong",
            code = 1003,
            address = "Av. Oscar Benavides 1234",
            latitude = -12.091994,
            longitude = -77.0440453,
            products = listOf(
                Product(
                    name = "Casaca Tienda 2",
                    salePrice = 10.50,
                    wholesalePrice = 8.25
                ),
                Product(
                    name = "Polo Tienda 2",
                    salePrice = 10.50,
                    wholesalePrice = 8.25
                ),
                Product(
                    name = "Zapatilla Tienda 2",
                    salePrice = 10.50,
                    wholesalePrice = 8.25
                )
            )
        ),
    )
    */
    val state = mainViewModel.state.value
    val stores = state.stores
    Scaffold(
        topBar ={
            MainTopBar(
                onProfileClicked = {
                    navController.navigate(Screen.Profile.route)
                }
            )
        }
    ) {
        MainContent(
            stores,
            navController
        )
    }
}

@Composable
fun MainContent(
    stores: List<Store>,
    navController: NavHostController
) {
    val currentSelectedStore = remember { mutableStateOf(Store())}
    val showDialog = remember { mutableStateOf(false) }
    if (showDialog.value) AlertDialogScreen(
        store = currentSelectedStore,
        navController = navController,
        showDialog = showDialog
    )
    LazyColumn(
        contentPadding = PaddingValues(all = SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ) {
        /*
        items(
            items = stores,
            key = { store ->
                store.id
            }
        ) { store ->
            StoreItem(
                store = store,
                navController = navController
            )
        }*/
        itemsIndexed(stores) { idx, store ->
            Card(
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
                    .clickable {
                        currentSelectedStore.value = store
                        showDialog.value = true
                    },
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
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(
        navController = rememberNavController()
    )
}