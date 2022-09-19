package com.hdev.qrcode.barcode.reader.ui.screens.create

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


data class ItemCreate(val icon: ImageVector, val title: String)
@Composable
fun ItemCreateQR(item: ItemCreate) {
    Card(modifier = Modifier
        .padding(5.dp)
        .clickable { },
        shape = RoundedCornerShape(6.dp),
        backgroundColor = MaterialTheme.colors.surface) {
        Column(modifier = Modifier
            .padding(5.dp)
            .padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(imageVector = item.icon, contentDescription = item.title)
            Text(text = item.title, textAlign = TextAlign.Center)
        }
    }
}