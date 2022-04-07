package com.manriquetavi.appgestor.navigation

sealed class Screen(val route: String) {
    object Splash: Screen("splash_screen")
    object Welcome: Screen("welcome_screen")
    object Login: Screen("login_screen")
    object Register: Screen("register_screen")
    object Main: Screen("main_screen")
    object Map: Screen("map_screen/{storeId}") {
        fun passStoreId(storeId: Int): String {
            return "map_screen/$storeId"
        }
    }
    object Visit: Screen("visit_screen"){
        fun passStoreId(storeId: Int): String {
            return "visit_screen/$storeId"
        }
    }
    object Report: Screen("report_screen") {
        fun passStoreId(storeId: Int): String {
            return "report_screen/$storeId"
        }
    }
}
