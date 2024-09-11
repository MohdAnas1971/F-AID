package com.example.f_aid.chatBot

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.f_aid.R
import com.example.f_aid.ui.theme.Black
import com.example.f_aid.ui.theme.Blue
import com.example.f_aid.ui.theme.BlueDark
import com.example.f_aid.ui.theme.GrayLL


@Composable
fun ChatList(
    list: MutableList<ChatData>
) {

    LazyColumn(modifier=Modifier.fillMaxWidth()) {

        items(list){

            if (it.role==ChatRoleEnum.USER.role){

                Row {
                    Icon(Icons.Rounded.AccountBox,
                        contentDescription ="Chat bot icon",
                        Modifier.size(33.dp))

                    Column {
                        Text(text = "YOU",
                            fontSize =18.sp,
                            fontWeight = FontWeight.Bold)
                        Text(
                            text =it.message,
                            modifier= Modifier
                                .fillMaxWidth()
                                //.background(Color.Cyan)
                                .padding(12.dp),
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }

                
            }else{

                Row {

                    Icon(
                        painterResource(id = R.drawable.chatbot),
                        contentDescription ="Chat bot icon",
                        Modifier.size(33.dp))

                    Column {
                        Text(text = "F-AID Chat Bot",
                            fontSize =18.sp,
                            fontWeight = FontWeight.Bold)
                        Text(
                            text =it.message,
                            modifier= Modifier
                                .fillMaxWidth()
                                //.background(Color.Blue)
                                .padding(12.dp),
                            color = BlueDark,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }

}


@Composable
fun ChatSuggestion(state: State) {


        Column(modifier= Modifier
            .fillMaxSize()
            .padding(bottom = 70.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {


            Column(modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {


                Icon(Icons.Rounded.Face,
                    contentDescription ="Chat bot icon",
                    Modifier.size(60.dp))
                Text(text = "How can I help you ?",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier

                        .padding(bottom = 8.dp))
            }

            Spacer(modifier = Modifier.height(100.dp))


            SuggestionQuestion("Which Food Is Good For Eyes ?", state)

            SuggestionQuestion("Bast Protein Source ?", state)

            SuggestionQuestion("How To Reduce Stress ?", state)

        }
    }


@Composable
fun SuggestionQuestion(question: String, state: State) {


    Box(modifier = Modifier

        .padding(8.dp)
        .border(2.dp, Blue)
    ){
        Text(text = question,
            color = Black,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            modifier = Modifier
                .background(GrayLL)
                .padding(16.dp)
                .fillMaxWidth()
                .size(width = 200.dp, height = 30.dp)
                //.clip(RoundedCornerShape(10.dp))
                // .border(2.dp,Color.Green)
                .clickable { state.inputText.value = question }
        )
    }

}


