package com.example.f_aid.homeUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.f_aid.R
import com.example.f_aid.otherFeature.WaterProgressBar
import com.example.f_aid.ui.theme.GreenT


@Composable
    fun  HomeFooter(navController: NavHostController) {

        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {

                WaterProgressBar()
               Column(verticalArrangement = Arrangement.Bottom,
                  modifier = Modifier.height(150.dp)
                   ) {
                   //Spacer(modifier = Modifier.height(20.dp))
                   IconButton(onClick = { navController.navigate("ChatBot") },
                       Modifier
                       //.padding(10.dp)
                       //.size(80.dp)
                   ) {
                       Image(painter = painterResource(id = R.drawable.chatbot),
                           contentDescription = "",
                           Modifier
                               // .padding(10.dp)
                               .size(80.dp))
                   }
               }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(GreenT)
                    .padding(5.dp)
            ) {
                IconButt(Icons.Rounded.AccountCircle){
                    navController.navigate("ProfilePage")
                }
                IconButt(Icons.Rounded.Home) {
                    navController.navigate("homePage")
                }
                IconButt(ImageVector.vectorResource(id = R.drawable.baseline_food_bank_24)) {
                    navController.navigate("FoodPrediction")
                }
                IconButt(Icons.Rounded.Notifications) {
                    navController.navigate("Notification")
                }
            }
        }
}



@Composable
fun IconButt(icon: ImageVector, openPage: () -> Unit) {

    IconButton(onClick = {openPage()},Modifier.size(50.dp)) {

        Icon(icon, contentDescription = "Icon button model",Modifier.size(35.dp))
    }
}