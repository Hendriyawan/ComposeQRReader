package com.hdev.qrcode.barcode.reader.ui.screens

sealed class Screen(val route: String) {
    object Splash : Screen(route = "splash")
    object Home : Screen(route = "home")
    object CreateQR : Screen(route = "create_qrcode")
    object ResultQR : Screen(route = "output_qrcode")
}