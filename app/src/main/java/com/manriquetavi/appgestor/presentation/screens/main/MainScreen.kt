package com.manriquetavi.appgestor.presentation.screens.main

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.manriquetavi.appgestor.domain.model.Response
import com.manriquetavi.appgestor.domain.model.Store
import com.manriquetavi.appgestor.navigation.Screen
import com.manriquetavi.appgestor.presentation.components.AlertDialogScreen
import com.manriquetavi.appgestor.presentation.components.ProgressBar
import com.manriquetavi.appgestor.presentation.components.StoreItem
import com.manriquetavi.appgestor.ui.theme.SMALL_PADDING
import com.manriquetavi.appgestor.util.Util
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun MainScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel = hiltViewModel()
) {

    val storesResponse = mainViewModel.storesState.value

    Scaffold(
        topBar ={
            MainTopBar(
                onProfileClicked = {
                    navController.navigate(Screen.Profile.route)
                }
            )
        }
    ) {
        when (storesResponse) {
            is Response.Loading -> ProgressBar()
            is Response.Success -> MainContent(stores = storesResponse.data, navController = navController)
            is Response.Error -> Util.printError(storesResponse.message)
        }
        Log.d("TAG", "MainScreen: $storesResponse")
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
        itemsIndexed(stores) { _, store ->
            StoreItem(
                store = store,
                navController = navController,
                currentSelectedStore = currentSelectedStore,
                showDialog = showDialog
            )
        }
    }
}


@ExperimentalCoroutinesApi
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(
        navController = rememberNavController()
    )
}