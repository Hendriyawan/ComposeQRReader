package com.hdev.qrcode.barcode.reader.utils

import android.content.Context
import androidx.compose.runtime.Composable
import com.nabinbhandari.android.permissions.PermissionHandler
import com.nabinbhandari.android.permissions.Permissions
import java.util.ArrayList

@Composable
//Handle runtime permission
fun Context.checkPermission(permissions: Array<String>, listener: (Boolean) -> Unit) {
    val options =
        Permissions.Options().setSettingsDialogTitle("Info").setSettingsDialogMessage("QR Code")
    Permissions.check(this, permissions, null, options, object : PermissionHandler() {
        override fun onGranted() {
            listener(true)
        }

        override fun onDenied(context: Context?, deniedPermissions: ArrayList<String>?) {
            listener(false)
        }
    })
}