package com.manriquetavi.appgestor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.manriquetavi.appgestor.navigation.SetUpNavGraph
import com.manriquetavi.appgestor.ui.theme.AppGestorTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppGestorTheme {
                // A surface container using the 'background' color from the theme
                navController = rememberNavController()
                SetUpNavGraph(navController = navController)
            }
        }
    }
}