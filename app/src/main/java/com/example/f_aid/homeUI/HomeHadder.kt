package com.example.f_aid.homeUI

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeHeader(context: Context) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.Yellow)
            .padding(5.dp)

    ) {
        IconButton(onClick = {}) {
            Icon(Icons.Rounded.Menu, contentDescription = "Menu icon")
        }
        Text(
            text = "F-AID",
            color =  Color.Red,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            modifier = Modifier
                .border(3.dp, color = Color.Red)
                .background(Color.White)
                .padding(start = 20.dp, end = 20.dp)
        )
        IconButton(onClick = {
            shareButtonAction(context)
        },
            modifier = Modifier
                .clip(RoundedCornerShape(100f))
                .background(Color.White),
        ) {
            Icon(Icons.Rounded.Share, contentDescription = "share icon")
        }
    }
}
fun shareButtonAction(context: Context) {
    val shareIntent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, "Check Out this Link: https://github.com/MohdAnas1971/F-AID.git")
        type = "text/plain"
    }
    val chooserIntent = Intent.createChooser(shareIntent, null)
    context.startActivity(chooserIntent)
}