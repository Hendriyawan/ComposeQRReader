package com.hdev.qrcode.barcode.reader.ui.screens.splash

import android.window.SplashScreen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hdev.qrcode.barcode.reader.ui.screens.Screen
import com.hdev.qrcode.barcode.reader.ui.theme.PemindaiQRCodeBarcodeTheme
import com.hdev.qrcode.barcode.reader.ui.theme.Teal500
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {
    PemindaiQRCodeBarcodeTheme {
        Surface(color = Teal500) {
            LaunchedEffect(key1 = true){
                delay(1000L)
                navController.navigate(Screen.Home.route){
                    popUpTo(Screen.Splash.route){
                        inclusive = true
                    }
                }
            }
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)){

            }
        }
    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    SplashScreen(rememberNavController())
}