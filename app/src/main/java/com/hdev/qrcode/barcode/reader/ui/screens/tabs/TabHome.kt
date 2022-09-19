package com.hdev.qrcode.barcode.reader.ui.screens.tabs

import android.annotation.SuppressLint
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.hdev.qrcode.barcode.reader.ui.theme.Teal500


enum class TabPageItem(val icon: ImageVector, val title: String) {
    Home(Icons.Filled.QrCodeScanner, "Scan"),
    Create(Icons.Filled.Edit, "Create"),
    History(Icons.Filled.History, "History"),
    Settings(Icons.Filled.Settings, "Settings")
}

@Composable
fun TabHome(selectedIndex: Int, onSelectedTab: (TabPageItem) -> Unit) {
    TabRow(backgroundColor = Teal500, selectedTabIndex = selectedIndex, indicator = {
        TabIndicator(
            tabPosition = it,
            index = selectedIndex
        )
    }) {
        TabPageItem.values().forEachIndexed { index, tabPageItem ->
            Tab(
                selected = index == selectedIndex,
                onClick = { onSelectedTab(tabPageItem) },
                text = { Text(text = tabPageItem.title) },
                icon = {
                    Icon(
                        imageVector = tabPageItem.icon,
                        contentDescription = tabPageItem.name
                    )
                },
                selectedContentColor = Color.White,
                unselectedContentColor = MaterialTheme.colors.onSurface.copy(ContentAlpha.disabled)
            )
        }
    }
}

@Composable
fun TabIndicator(tabPosition: List<TabPosition>, index: Int) {
    val transition = updateTransition(targetState = index, label = "")
    val leftIndicator by transition.animateDp(label = "", transitionSpec = {
        spring(stiffness = Spring.StiffnessHigh)
    }) {
        tabPosition[it].left
    }

    val rightIndicator by transition.animateDp(label = "", transitionSpec = {
        spring(stiffness = Spring.StiffnessHigh)
    }) {
        tabPosition[it].right
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.BottomStart)
            .offset(x = leftIndicator)
            .width(rightIndicator - leftIndicator)
            .padding(5.dp)
            .fillMaxSize()
            .border(
                width = 2.dp,
                color = MaterialTheme.colors.secondary,
                shape = RoundedCornerShape(20.dp)
            )

    )
}