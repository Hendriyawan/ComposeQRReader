package com.hdev.qrcode.barcode.reader.ui.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.hdev.qrcode.barcode.reader.ui.screens.Screen
import com.hdev.qrcode.barcode.reader.ui.screens.home.MainHomeScreen
import com.hdev.qrcode.barcode.reader.ui.screens.splash.SplashScreen

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun NavigationScreen() {
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = Screen.Splash.route){
        composable(Screen.Splash.route){
            SplashScreen(navController = navigationController)
        }
        composable(Screen.Home.route){
            MainHomeScreen()
        }
        composable(Screen.CreateQR.route){

        }
        composable(Screen.ResultQR.route){

        }
    }
    
}