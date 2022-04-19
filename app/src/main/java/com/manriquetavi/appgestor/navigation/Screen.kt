package com.manriquetavi.appgestor.navigation

sealed class Screen(val route: String) {
    object Splash: Screen("splash_screen")
    object Welcome: Screen("welcome_screen")
    object Login: Screen("login_screen")
    object Register: Screen("register_screen")
    object Main: Screen("main_screen")
    object Profile: Screen("profile_screen")
    object Map: Screen("map_screen/{latitude}/{longitude}") {
        fun passLatitudeAndLongitude(
            latitude: Double,
            longitude: Double
        ): String {
            return "map_screen/$latitude/$longitude"
        }
    }
    object Visit: Screen("visit_screen/{storeId}"){
        fun passStoreIdToVisit(storeId: String): String {
            return "visit_screen/$storeId"
        }
    }
    object Report: Screen("report_screen/{storeId}") {
        fun passStoreIdToReport(storeId: String): String {
            return "report_screen/$storeId"
        }
    }
}
