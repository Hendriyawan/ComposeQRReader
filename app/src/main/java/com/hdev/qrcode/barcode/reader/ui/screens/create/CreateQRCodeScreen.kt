package com.hdev.qrcode.barcode.reader.ui.screens.create

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hdev.qrcode.barcode.reader.R

@ExperimentalFoundationApi
@Composable
fun CreateQRCodeScreen() {
    val listMenuCreate = listOf(
        ItemCreate(Icons.Filled.Link, stringResource(R.string.link)),
        ItemCreate(Icons.Filled.TextSnippet, stringResource(R.string.text)),
        ItemCreate(Icons.Filled.Wifi, stringResource(R.string.wifi)),
        ItemCreate(Icons.Filled.Event, stringResource(R.string.event)),
        ItemCreate(Icons.Filled.Contacts, stringResource(R.string.contact)),
        ItemCreate(Icons.Filled.Email, stringResource(R.string.email)),
        ItemCreate(Icons.Filled.Call, stringResource(R.string.phone)),
        ItemCreate(Icons.Filled.Sms, stringResource(R.string.sms))
    )

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(2)
        ){
            items(listMenuCreate.size){ index ->
                ItemCreateQR(item = listMenuCreate[index])
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun CreateQRCodeScreenPreview() {
    CreateQRCodeScreen()
}