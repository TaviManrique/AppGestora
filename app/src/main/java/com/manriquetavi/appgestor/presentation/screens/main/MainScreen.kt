package com.manriquetavi.appgestor.presentation.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.manriquetavi.appgestor.R
import com.manriquetavi.appgestor.domain.model.Product
import com.manriquetavi.appgestor.domain.model.Store
import com.manriquetavi.appgestor.navigation.Screen
import com.manriquetavi.appgestor.ui.theme.SMALL_PADDING

@Composable
fun MainScreen(
    navController: NavHostController
) {
    //val stores = listOf<Store>() Firebase
    val stores = listOf(
        Store(
            id = 1,
            name = "Metro",
            code = 1001,
            address = "C. Lima 123",
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
            name = "Tottus",
            code = 1002,
            address = "Av. Javier Prado 2345",
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
            name = "Plaza Vea",
            code = 1003,
            address = "Av. Oscar Benavides 1234",
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
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ) {
        items(
            items = stores,
            key = { store ->
                store.id
            }
        ) { store ->
            StoreItem(store = store, navController = navController)
        }
    }
}

@Composable
fun StoreItem(
    store: Store,
    navController: NavHostController
) {
    Card(
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()
            .clickable { navController.navigate(Screen.Visit.passStoreId(storeId = store.id)) },
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
                    .clickable { navController.navigate(Screen.Map.passStoreId(storeId = store.id)) },
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

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(
        navController = rememberNavController()
    )
}