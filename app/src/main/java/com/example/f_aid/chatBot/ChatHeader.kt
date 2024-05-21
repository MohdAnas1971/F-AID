package com.example.f_aid.chatBot

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.f_aid.ui.theme.Blue


@Composable
fun ChatHeader(navController: NavHostController) {

    Row(modifier = Modifier.fillMaxWidth()
        , verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {

        IconButton(onClick = {navController.navigate("homePage")}) {
            Icon(Icons.Rounded.ArrowBack,
                contentDescription = "Back to home")

        }

        Text(text = " F-AID Chat Bot",
            color = Blue,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
               // .border(1.dp, color = Black,)
                //.fillMaxWidth()
                //.background(Color.LightGray)
                .padding(8.dp)
        )

IconButton(onClick = {}) {
    Icon(Icons.Rounded.Share,
        contentDescription ="Share app",
        )
}

    }

}