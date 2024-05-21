package com.example.f_aid.scanner

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.launch
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import com.example.f_aid.R


@Composable
fun Camera(
    cameraLauncher: ManagedActivityResultLauncher<Void?, Bitmap?>,
    bitmap: Bitmap?,
    permissionLauncher: ManagedActivityResultLauncher<String, Boolean>,
    navController: NavHostController,
    recognizedText: MutableState<String?>,

    ) {

    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {

        BackButton(navController, "BACK", "homepage", R.drawable.baseline_arrow_back_24)//

        if (recognizedText.value != null) {
            DisplayImage(cameraLauncher, permissionLauncher, bitmap, navController, context)
        } else {

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,

                ) {
                TextButton(
                    onClick = {
                        clickAction(permissionLauncher, cameraLauncher, context)
                    }, Modifier.size(100.dp)
                ) {

                    Icon(
                        painterResource(id = R.drawable.baseline_photo_camera_24),
                        contentDescription = "camera icon",
                        Modifier.size(80.dp)
                    )
                }
            }
        }
    }

    if (bitmap != null) {
        processImageForTextRecognition(bitmap, context, recognizedText)
    }
}


fun clickAction(
    permissionLauncher: ManagedActivityResultLauncher<String, Boolean>,
    cameraLauncher: ManagedActivityResultLauncher<Void?, Bitmap?>,
    context: Context,
) {

    val cameraPermission = android.Manifest.permission.CAMERA


    if (ContextCompat.checkSelfPermission(
            context, cameraPermission
        ) == PackageManager.PERMISSION_GRANTED
    ) {

        cameraLauncher.launch()

    } else {
        permissionLauncher.launch(cameraPermission)
    }
}