package com.example.f_aid.scanner

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun BackButton(navController: NavHostController,textValue:String,actionRoute:String,iconId:Int) {

    Row(
        modifier = Modifier
            .fillMaxWidth(0.5f)
           // .height(.dp)
    ) {

        TextButton(onClick = { navController.navigate(actionRoute) },
        ) {
            Icon(painterResource(id = iconId), contentDescription = "")
            Text(
                text = textValue,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,


                )
        }
    }
}