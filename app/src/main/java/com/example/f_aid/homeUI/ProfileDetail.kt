package com.example.f_aid.homeUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.f_aid.R


@Composable
 fun PersonalInfo() {
    Column(
     Modifier
      .fillMaxSize()
      .padding(8.dp)
    ) {
     Column(horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
       .fillMaxWidth()
       .padding(bottom = 8.dp)
     ) {
      Image(painterResource(id = R.drawable.indian_flag_min),
       contentDescription ="",
       modifier = Modifier
        .size(200.dp)
        .clip(shape = RoundedCornerShape(8.dp))
        .border(5.dp, color = Color.Black),
       contentScale = ContentScale.Crop,
       )
      Text(text = "India1947@gmail.com",
       style = TextStyle(fontWeight = FontWeight.Bold, fontSize =24.sp ) )
     }
     Divider(
      color = Color.Black,
      thickness = 2.dp,
      modifier = Modifier.fillMaxWidth()
     )
     Text(text = "Age : 25",
      style = TextStyle(fontWeight = FontWeight.Bold, fontSize =24.sp )
     )
     Text(text = "Wight : 70",
      style = TextStyle(fontWeight = FontWeight.Bold, fontSize =24.sp )
     )
    }
}





//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfilePage(navController: NavHostController) {
 var name by remember { mutableStateOf("John Doe") }
 var bio by remember { mutableStateOf("Android Developer, Tech Enthusiast, and Blogger.") }

 Box(
  modifier = Modifier
   .fillMaxSize()
   .background(Color(0xFFEDE7F6))
 ) {
  Column(
   horizontalAlignment = Alignment.CenterHorizontally,
   verticalArrangement = Arrangement.Top,
   modifier = Modifier
    .fillMaxSize()
    .padding(16.dp)
  ) {
   Row(horizontalArrangement = Arrangement.End,
    modifier = Modifier.fillMaxWidth().height(50.dp)) {
    LoginSection(navController)
   }
   Spacer(modifier = Modifier.height(32.dp))

   Image(
    painter = painterResource(id = R.drawable.indian_flag_min),
    contentDescription = "Profile Picture",
    modifier = Modifier
     .size(128.dp)
     .clip(CircleShape)
     .background(Color(0xFF6200EA)),
    contentScale = ContentScale.Crop
   )

   Spacer(modifier = Modifier.height(16.dp))

   BasicTextField(
    value = name,
    onValueChange = { name = it },
    modifier = Modifier
     .background(Color.White, CircleShape)
     .padding(horizontal = 16.dp, vertical = 8.dp),
    textStyle = LocalTextStyle.current.copy(
     fontSize = 24.sp,
     fontWeight = FontWeight.Bold,
     color = Color.Black
    ),
    keyboardOptions = KeyboardOptions.Default.copy(
     imeAction = ImeAction.Done
    )
   )

   Spacer(modifier = Modifier.height(8.dp))

   BasicTextField(
    value = bio,
    onValueChange = { bio = it },
    modifier = Modifier
     .background(Color.White, CircleShape)
     .padding(horizontal = 16.dp, vertical = 8.dp),
    textStyle = LocalTextStyle.current.copy(
     fontSize = 16.sp,
     color = Color.DarkGray
    ),
    keyboardOptions = KeyboardOptions.Default.copy(
     imeAction = ImeAction.Done
    )
   )

   Spacer(modifier = Modifier.height(32.dp))

Box(modifier = Modifier
 .fillMaxWidth()
 .clickable(true, onClick = { navController.navigate("PersonalInfo") }),
 contentAlignment = Alignment.Center) {
 ProfileInfoItem(
  iconRes = R.drawable.scan_icon,
  infoText = "Personal Information"
 )
}

   ProfileInfoItem(
    iconRes = R.drawable.baseline_email_24,
    infoText = "john.doe@example.com"
   )

   ProfileInfoItem(
    iconRes = R.drawable.baseline_local_phone_24,
    infoText = "+1 234 567 890"
   )

   ProfileInfoItem(
    iconRes = R.drawable.baseline_location_on_24,
    infoText = "San Francisco, CA"
   )
  }
 }
}

@Composable
fun ProfileInfoItem(
 iconRes: Int,
 infoText: String
) {
 Row(
  verticalAlignment = Alignment.CenterVertically,
  modifier = Modifier
   .fillMaxWidth()
   .padding(vertical = 8.dp, horizontal = 16.dp)
 ) {
  Image(
   painter = painterResource(id = iconRes),
   contentDescription = null,
   modifier = Modifier.size(24.dp)
  )
  Spacer(modifier = Modifier.width(16.dp))
  Text(
   text = infoText,
   style = LocalTextStyle.current.copy(fontSize = 16.sp, color = Color.Black)
  )
 }
}

@Composable
private fun LoginSection(navController: NavHostController) {

 Button(onClick = { navController.navigate("LoginPage") },
  modifier = Modifier,
  colors = ButtonDefaults.buttonColors(
   containerColor = Color.Transparent,
   // contentColor = Color.White
  )
  //.size(width = 90.dp, height = 25.dp)
 ) {
  Text(text = "LOGOUT",
   modifier = Modifier
    .border(2.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
    .background(color = Color.Gray, shape = RoundedCornerShape(10.dp))
    .padding(start = 8.dp, end = 6.dp),
   color = Color.Green, fontSize = 20.sp
  )
 }

}

