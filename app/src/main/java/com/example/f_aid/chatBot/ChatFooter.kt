package com.example.f_aid.chatBot

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import com.example.f_aid.ui.theme.Black
import com.example.f_aid.ui.theme.Blue
import com.example.f_aid.ui.theme.Blue3


@Composable
fun  ChatFooter(
    state: State, onClick: (text: String) -> Unit

) {
    val isConnectedNetwork by connectivityStatus()


    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            //.background(Blue)
            .padding(10.dp)
            .border(2.dp,color= Blue)
        ) {
        OutlinedTextField(
            value = state.inputText.value,
            onValueChange = { state.inputText.value = it },
            placeholder = { Text(text = "F-AID : Ask For Your Health") },
            singleLine = true,
            modifier = Modifier
                .weight(1f)
            // .background(BlueLight)
        )


        if (isConnectedNetwork) {

            IconButton(onClick = {
                    onClick(state.inputText.value)
                    state.inputText.value = ""
            }) {
                Icon(
                    Icons.Rounded.ArrowForward,
                    contentDescription = "send button",
                    modifier = Modifier
                        .size(50.dp)
                        .border(1.dp, color = Black)
                        .rotate(270f)
                        .clip(CircleShape)
                        .background(Blue3)
                        .padding(8.dp),
                    //tint = Color.Green
                )
            }}else {
            NetworkWarning()
        }
    }
}