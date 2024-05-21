package com.example.f_aid.homeUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.f_aid.R



    @Composable
    fun  HomeFooter(navController: NavHostController) {

        Column {
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                IconButton(onClick = { navController.navigate("ChatBot") },
                    Modifier
                        .padding(10.dp)
                        .size(80.dp)) {

                    Image(painter = painterResource(id = R.drawable.chatbot),
                        contentDescription = "",
                        Modifier
                            .padding(10.dp)
                            .size(80.dp))
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()

                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(Color.White)
                    .padding(5.dp)
            ) {

                IconButton(onClick = {},Modifier.size(50.dp)) {

                    Icon(Icons.Rounded.AccountCircle, contentDescription = "User Account",Modifier.size(50.dp))
                }
                IconButton(onClick = {},Modifier.size(50.dp)) {
                    Icon(Icons.Rounded.Home, contentDescription = "shopping icon",Modifier.size(35.dp))
                }
                IconButton(onClick = {},Modifier.size(50.dp)) {
                    Icon(Icons.Rounded.Notifications, contentDescription = "notifications icon",Modifier.size(35.dp))
                }
            }
        }

    }