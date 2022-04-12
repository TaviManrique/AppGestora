package com.manriquetavi.appgestor.presentation.components

import android.widget.Toast
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.manriquetavi.appgestor.domain.model.Store
import com.manriquetavi.appgestor.navigation.Screen


@Composable
fun AlertDialogScreen(
    store: MutableState<Store>,
    navController: NavHostController,
    showDialog: MutableState<Boolean>
) {
    val context = LocalContext.current
    AlertDialog(
        onDismissRequest = { showDialog.value = false },
        title = {
            Text(
                text = store.value.name!!
            ) },
        text = {
            Text(
                text = "Atendera el pdv?"
            ) },
        confirmButton = {
            TextButton(onClick = {
                showDialog.value = false
                navController.navigate(Screen.Visit.passNameAndAddressToVisit(
                    storeName = store.value.name!!,
                    storeAddress = store.value.address!!,
                    storeId = store.value.id!!)
                )
                Toast.makeText(context, "Confirm text click", Toast.LENGTH_SHORT).show()
            }) {
                Text(
                    text = "SI"
                )
            } },
        dismissButton = {
            TextButton(
                onClick = {
                    showDialog.value = false
                    Toast.makeText(context, "Dismiss text click", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text(text = "NO")
            }
        }
    )
}