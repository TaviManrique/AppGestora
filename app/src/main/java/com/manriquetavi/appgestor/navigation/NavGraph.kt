package com.manriquetavi.appgestor.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.manriquetavi.appgestor.presentation.screens.login.LoginScreen
import com.manriquetavi.appgestor.presentation.screens.main.MainScreen
import com.manriquetavi.appgestor.presentation.screens.map.MapScreen
import com.manriquetavi.appgestor.presentation.screens.profile.ProfileScreen
import com.manriquetavi.appgestor.presentation.screens.register.RegisterScreen
import com.manriquetavi.appgestor.presentation.screens.report.ReportScreen
import com.manriquetavi.appgestor.presentation.screens.splash.SplashScreen
import com.manriquetavi.appgestor.presentation.screens.visit.VisitScreen
import com.manriquetavi.appgestor.presentation.screens.welcome.WelcomeScreen
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun SetUpNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.Register.route) {
            RegisterScreen(navController = navController)
        }
        composable(route = Screen.Main.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }
        composable(
            route = Screen.Map.route,
            arguments = listOf(
                navArgument("latitude") {
                    type = NavType.FloatType
                },
                navArgument("longitude") {
                    type = NavType.FloatType
                }
            )
        ) {
            MapScreen(navController = navController)
        }
        composable(
            route = Screen.Visit.route,
            arguments = listOf(
                navArgument("storeName") {
                    type = NavType.StringType
                },
                navArgument("storeAddress") {
                    type = NavType.StringType
                },
                navArgument("storeId") {
                    type = NavType.StringType
                }
            )
        ) {
            VisitScreen(navController = navController)
        }
        composable(
            route = Screen.Report.route,
            arguments = listOf(navArgument("storeId") {
                type = NavType.StringType
            })
        ) {
            ReportScreen(navController = navController)
        }
    }
}