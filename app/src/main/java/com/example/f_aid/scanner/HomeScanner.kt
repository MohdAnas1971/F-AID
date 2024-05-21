package com.example.f_aid.scanner

import android.graphics.Bitmap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController

@Composable
fun cameraApp(navController: NavHostController): MutableState<String?> {

    var bitmap by remember {
        mutableStateOf<Bitmap?>(null)
    }
    val recognizedText = remember {
        StateText().recognizedText
    }


    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) {
        bitmap = it
    }


    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) {

        if (it) {
            cameraLauncher.launch()
        }

    }

    Camera(cameraLauncher, bitmap, permissionLauncher, navController, recognizedText)

    return recognizedText
}