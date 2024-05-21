package com.example.f_aid.scanner

import android.content.Context
import android.graphics.Bitmap
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.f_aid.R

@Composable
fun DisplayImage(
    cameraLauncher: ManagedActivityResultLauncher<Void?, Bitmap?>,
    permissionLauncher: ManagedActivityResultLauncher<String, Boolean>,
    bitmap: Bitmap?,
    navController: NavHostController,
    context: Context
) {


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,

        ) {

        Image(bitmap= bitmap!!.asImageBitmap(),
            contentDescription ="captured Image" ,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        )
        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly) {

            BackButton( navController,"","CameraApp", R.drawable.baseline_cancel_presentation_24)//

            BackButton( navController,"","DisplayResult", R.drawable.baseline_document_scanner_24)//
        }

        TextButton(
            onClick = {
                clickAction( permissionLauncher, cameraLauncher,context)
            }, Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally)
        ) {

            Icon(
                painterResource(id = R.drawable.baseline_photo_camera_24),
                contentDescription = "camera icon",
                Modifier.size(80.dp)
            )
        }

    }

}