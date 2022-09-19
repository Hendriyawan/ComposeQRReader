package com.hdev.qrcode.barcode.reader.ui.screens.home

import android.Manifest
import android.annotation.SuppressLint
import android.graphics.Color
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.ScanMode
import com.google.zxing.BarcodeFormat
import com.google.zxing.Result
import com.hdev.qrcode.barcode.reader.R
import com.hdev.qrcode.barcode.reader.utils.checkPermission
import kotlinx.coroutines.launch

enum class State {
    ON_RESUME,
    ON_STOP,
    ON_DESTROY
}
@SuppressLint("RememberReturnType")
@Composable
fun MainHomeScanScreen() {
    //Context
    val context = LocalContext.current
    //Permission
    val permissions = arrayOf(Manifest.permission.CAMERA)
    //State for permissions
    var granted by remember { mutableStateOf(false) }
    //Lifecycle
    val lifecycle = LocalLifecycleOwner.current
    Box(modifier = Modifier.fillMaxSize()) {
        context.checkPermission(permissions) { granted = it }
        if (granted) {
            //Scanner View
            ScannerView(modifier = Modifier
                .fillMaxSize()
                .align(alignment = Alignment.Center), lifecycle) { success, result, message ->
                if (success) {
                    Toast.makeText(context,"${result?.text}", Toast.LENGTH_SHORT).show()
                }
            }
        }
        //ExtendedFAB
        ExtendedFloatingActionButton(modifier = Modifier
            .wrapContentSize(Alignment.BottomCenter)
            .padding(bottom = 16.dp)
            .align(alignment = Alignment.BottomCenter)
            .clickable {},
            text = {
                Text(text = stringResource(R.string.scan_image))
            },
            onClick = {

            },
            icon = { Icon(Icons.Filled.Image, contentDescription = "scan image") }
        )
    }
}

@Composable
fun ScannerView(modifier: Modifier, lifecycle: LifecycleOwner, callback: (Boolean, Result?, String?) -> Unit) {
    //Scope
    val scope = rememberCoroutineScope()
    AndroidView(modifier = modifier, factory = { context ->
        CodeScannerView(context).apply {
            isAutoFocusButtonVisible = true
            autoFocusButtonColor = Color.WHITE
            frameAspectRatioWidth = 1f
            frameAspectRatioHeight = 1f
            frameCornersSize = 50.dp.compareTo(50.dp)
            frameColor = Color.WHITE
            CodeScanner(context, this).apply {
                camera = CodeScanner.CAMERA_BACK
                formats = listOf(
                    BarcodeFormat.QR_CODE,
                    BarcodeFormat.EAN_8,
                    BarcodeFormat.CODABAR)
                scanMode = ScanMode.PREVIEW
                isFlashEnabled = false
                setDecodeCallback {
                    scope.launch {
                        callback(true, it, "Success")
                    }
                }
                setErrorCallback {
                    scope.launch {
                        callback(false, null, it.localizedMessage)
                    }
                }
                lifecycle.lifecycle.addObserver(LifecycleEventObserver { _, event ->
                    when(event){
                        Lifecycle.Event.ON_RESUME -> startPreview()
                        Lifecycle.Event.ON_PAUSE -> releaseResources()
                    }
                })
            }
        }
    })
}

@Composable
@Preview
fun ScannerPreview() {
    MainHomeScanScreen()
}