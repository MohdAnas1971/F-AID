package com.example.f_aid.homeUI

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.f_aid.R
import com.example.f_aid.otherFeature.WaterProgressBar


@Composable
fun HomePage(navController: NavHostController) {

    val context = LocalContext.current
           // Remember the current page index with mutableStateOf
Box(modifier = Modifier.fillMaxSize()){

    Image(
        painterResource(id = (R.drawable.food_green)),
        modifier =Modifier.fillMaxSize(),
        contentDescription =null,
        contentScale = ContentScale.Crop,
        alpha = 0.7f
    )
    HomeContent(navController,context)
}
}
@Composable
fun HomeContent(navController: NavHostController, context: Context) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
           // .padding(start = 5.dp, end = 5.dp)

        verticalArrangement = Arrangement.SpaceBetween
    ) {
            Column(
                modifier= Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                HomeHeader(context)
                Row(horizontalArrangement = Arrangement.SpaceBetween  ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, top = 5.dp, end = 5.dp)
                ) {
                    WaterProgressBar()
                }

            }
        MiddleContent(navController)
       // Spacer(modifier =Modifier.height(20.dp) )
        HomeFooter(navController)
    }
}

@Composable
fun MiddleContent(navController: NavHostController) {

    Row(
        horizontalArrangement =Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        IconButton(onClick = {navController.navigate("CameraApp")},
            Modifier.size(120.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_document_scanner_24),
                contentDescription = "Scanning Icon",
                modifier = Modifier.size(1115.dp)
            )
        }
    }


}








