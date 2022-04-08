package com.manriquetavi.appgestor.presentation.screens.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapScreen(navController: NavHostController) {

    val latitude = navController.currentBackStackEntry?.arguments?.getFloat("latitude")?.toDouble()
    val longitude = navController.currentBackStackEntry?.arguments?.getFloat("longitude")?.toDouble()

    Scaffold(
        topBar = {
            MapTopBar(navController = navController)
        }
    ) {
        if (latitude != null && longitude != null) {
            val location = LatLng(latitude, longitude)
            val cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(location, 15f)
            }
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState
            ) {
                Marker(
                    position = location,
                    title = "Store",
                    snippet = "Store in Peru"
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MapScreenPreview() {
    MapScreen(navController = rememberNavController())
}