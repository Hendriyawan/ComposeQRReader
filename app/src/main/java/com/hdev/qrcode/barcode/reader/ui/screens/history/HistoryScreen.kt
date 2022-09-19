package com.hdev.qrcode.barcode.reader.ui.screens.history

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HistoryScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(Icons.Filled.History, contentDescription = "history")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "No History Found !")
    }
}

@Composable
@Preview
fun HistoryScreenPreview() {
    HistoryScreen()
}