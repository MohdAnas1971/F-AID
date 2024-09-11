package com.example.f_aid.chatBot

import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController


@Composable
fun ChatBot(
    navController: NavHostController,
    viewModel:ViewModelCha= viewModel()
    ) {
    val state = remember{State()}

    Column(
        verticalArrangement = Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    )
    {
        ChatHeader(navController)
        
        Box(
            modifier = Modifier
                .weight(1f),
         contentAlignment = Alignment.Center
        ){


            if ( viewModel.list.isEmpty()){
                ChatSuggestion(state)
            }else{
                ChatList(list = viewModel.list)
            }
           
        }
        ChatFooter(state) {
            if (it.isNotEmpty()){
viewModel.sendMassageF(it,"Bot")

            }
        }
    }
}



