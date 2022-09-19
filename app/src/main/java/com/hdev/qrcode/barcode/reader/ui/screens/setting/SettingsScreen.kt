package com.hdev.qrcode.barcode.reader.ui.screens.setting

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hdev.qrcode.barcode.reader.R
import com.hdev.qrcode.barcode.reader.ui.theme.PemindaiQRCodeBarcodeTheme

@Composable
fun SettingScreen() {
    val stateDarkTheme = remember { mutableStateOf(true)}
    val stateVibrate = remember { mutableStateOf(false) }
    val stateSound = remember { mutableStateOf(true) }
    val stateAutoCopyToClipboard = remember { mutableStateOf(true) }
    val stateOpenWebAutomatically = remember { mutableStateOf(true) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)) {
        LazyColumn {
            item {
                Card(modifier = Modifier.padding(8.dp),
                shape = RoundedCornerShape(6.dp),
                backgroundColor = MaterialTheme.colors.surface) {
                    Column(modifier = Modifier
                        .padding(8.dp)
                        .padding(8.dp)) {
                        Text(text = stringResource(R.string.user_interface),
                            Modifier.align(Alignment.Start),
                            style = TextStyle(color = MaterialTheme.colors.secondary,
                                fontWeight = FontWeight.Medium))
                        Spacer(modifier = Modifier.height(10.dp))
                        //Switch Dark Theme setting
                        SwitchSetting(
                            name = stringResource(R.string.dark_mode),
                            checked = stateDarkTheme.value,
                            onCheckedChange = {
                                stateDarkTheme.value = it
                            },
                        )
                    }
                }
            }
            item {
                Card(modifier = Modifier.padding(8.dp),
                    shape = RoundedCornerShape(6.dp),
                    backgroundColor = MaterialTheme.colors.surface) {
                    Column(modifier = Modifier
                        .padding(8.dp)
                        .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = stringResource(R.string.scanner),
                            Modifier.align(Alignment.Start),
                            style = TextStyle(color = MaterialTheme.colors.secondary,
                                fontWeight = FontWeight.Medium))
                        Spacer(modifier = Modifier.height(10.dp))
                        //Switch Vibrate setting
                        SwitchSetting(
                            name = stringResource(R.string.vibrate),
                            checked = stateVibrate.value,
                            onCheckedChange = {
                                stateVibrate.value = it
                            },
                        )
                        //Switch Sound setting
                        SwitchSetting(
                            name = stringResource(R.string.sound),
                            checked = stateSound.value,
                            onCheckedChange = {
                                stateSound.value = it
                            },
                        )
                        //Switch Copy To Clipboard setting
                        SwitchSetting(
                            name = stringResource(R.string.auto_copy_to_clipboard),
                            checked = stateAutoCopyToClipboard.value,
                            onCheckedChange = {
                                stateAutoCopyToClipboard.value = it
                            },
                        )
                        //Switch Open Web setting
                        SwitchSetting(
                            name = stringResource(R.string.open_web_automatically),
                            checked = stateOpenWebAutomatically.value,
                            onCheckedChange = {
                                stateOpenWebAutomatically.value = it
                            },
                        )

                    }
                }
            }
        }
    }
}

@Composable
fun SwitchSetting(
    name: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = name, modifier = Modifier.weight(1f))
        Switch(checked = checked, onCheckedChange = onCheckedChange, colors = SwitchDefaults.colors())
    }
}


@Composable
@Preview(showBackground = true)
fun SettingScreenPreview() {
    PemindaiQRCodeBarcodeTheme(darkTheme = false) {
        Surface(color = MaterialTheme.colors.background) {
            SettingScreen()
        }
    }
}


@Composable
@Preview(showBackground = true)
fun SettingScreenPreviewDark() {
    PemindaiQRCodeBarcodeTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.background) {
            SettingScreen()
        }
    }
}