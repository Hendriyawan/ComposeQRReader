package com.hdev.qrcode.barcode.reader.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.hdev.qrcode.barcode.reader.ui.screens.create.CreateQRCodeScreen
import com.hdev.qrcode.barcode.reader.ui.screens.history.HistoryScreen
import com.hdev.qrcode.barcode.reader.ui.screens.setting.SettingScreen
import com.hdev.qrcode.barcode.reader.ui.screens.tabs.TabHome
import com.hdev.qrcode.barcode.reader.ui.screens.tabs.TabPageItem
import com.hdev.qrcode.barcode.reader.ui.theme.PemindaiQRCodeBarcodeTheme
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun MainHomeScreen() {
    PemindaiQRCodeBarcodeTheme {
        val pagerState = rememberPagerState(pageCount = TabPageItem.values().size)
        val scope = rememberCoroutineScope()
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Scaffold(topBar = {
                TabHome(
                    selectedIndex = pagerState.currentPage,
                    onSelectedTab = {
                        scope.launch {
                            pagerState.animateScrollToPage(it.ordinal)
                        }
                    })
            }) {
                HorizontalPager(state = pagerState) { index ->
                    when(index){
                        0 -> {
                            MainHomeScanScreen()
                        }
                        1 -> {
                            CreateQRCodeScreen()
                        }
                        2 -> {
                            HistoryScreen()
                        }
                        3 -> {
                            SettingScreen()
                        }
                    }
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
@Preview
fun MainHomeScreenPreview() {
    MainHomeScreen()
}