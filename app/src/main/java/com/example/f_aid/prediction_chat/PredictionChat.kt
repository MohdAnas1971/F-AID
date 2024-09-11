package com.example.f_aid.prediction_chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.f_aid.R
import com.example.f_aid.chatBot.ChatData
import com.example.f_aid.chatBot.ChatRoleEnum
import com.example.f_aid.chatBot.ViewModelCha
import com.example.f_aid.ui.theme.BlueDark


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FoodPrediction(viewModel: ViewModelCha = viewModel()) {
    var selectedAllOption by remember { mutableStateOf("") }
    var done by remember { mutableStateOf(false) }
    var timing=""
    var type =""
    var taste=""
 Column(
     Modifier
         .fillMaxSize()
         .padding(5.dp))
 {

     Row(horizontalArrangement = Arrangement.Center,
         modifier = Modifier.fillMaxWidth()) {
Text(text = "All Options are optional",
    fontStyle = FontStyle.Italic,
    fontWeight = FontWeight.Bold,
    fontSize = 18.sp)
     }
     Spacer(modifier = Modifier.height(40.dp))
     Row(Modifier.fillMaxWidth()) {
         ItemIfo(R.drawable.baseline_timelapse_24,"Meal For")
          timing=menuForWhy()
     }
  //   Spacer(modifier = Modifier.height(40.dp))
     Row(Modifier.fillMaxWidth()) {
         ItemIfo(R.drawable.baseline_restaurant_menu_24,"Meal Type")
          type=vagMenu()

     }

   //  Spacer(modifier = Modifier.height(40.dp))

     Row(Modifier.fillMaxWidth()) {
         ItemIfo(R.drawable.baseline_soup_kitchen_24,"Taste")
         taste= menuTaste()
     }
     if(done){
         selectedAllOption= "Recommend me Name of dishes that should be  $timing ,$type ,and $taste with number point ."
     }
     Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
         Button(onClick = {done=true
            if ( selectedAllOption!=""){ viewModel.sendMassageF(selectedAllOption,check="prediction")}
                          },
             colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
         ) {
             Text(text ="Done" )
         }
     }
     Output(viewModel.listRec)
 }
}


@Composable
fun Output(list: MutableList<ChatData>) {

    LazyColumn(modifier=Modifier.fillMaxWidth()) {

        items(list){

            if (it.role== ChatRoleEnum.USER.role){

                Row {
                    Icon(
                        Icons.Rounded.AccountBox,
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
fun ItemIfo(
    iconRes: Int,
    infoText: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier

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
fun vagMenu(): String {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("") }

    Column (
        Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(8.dp)
       ){
        Button(onClick = { expanded = true }) {
            Text("Tap:$selectedOption")
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            properties = PopupProperties(focusable = true)
        ) {
            RadioMenuItem(
                text = "Veg",
                isSelected = selectedOption == " Veg",
                onClick = {
                    selectedOption = "Veg"
                    expanded = false
                }
            )
            RadioMenuItem(
                text = "Non veg",
                isSelected = selectedOption == "Non Veg",
                onClick = {
                    selectedOption = "Non Veg"
                    expanded = false
                }
            )
            RadioMenuItem(
                text = "Only agg",
                isSelected = selectedOption == "Only agg",
                onClick = {
                    selectedOption = "Only agg"
                    expanded = false
                }
            )
        }

      //  Text(text = "Selected option: $selectedOption", fontSize = 20.sp, modifier = Modifier.padding(top = 16.dp))
    }
    return  selectedOption
}


@Composable
fun menuForWhy(): String {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("") }

    Column (
        Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(8.dp)
    ){
        Button(onClick = { expanded = true }) {
            Text("Tap:$selectedOption")
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            properties = PopupProperties(focusable = true)
        ) {
            RadioMenuItem(
                text = "Breakfast",
                isSelected = selectedOption == "Breakfast",
                onClick = {
                    selectedOption = "Breakfast"
                    expanded = false
                }
            )
            RadioMenuItem(
                text = "Breakfast + Lunch",
                isSelected = selectedOption == "Breakfast + Lunch",
                onClick = {
                    selectedOption = "Breakfast + Lunch"
                    expanded = false
                }
            )
            RadioMenuItem(
                text = "Lunch",
                isSelected = selectedOption == "Lunch",
                onClick = {
                    selectedOption = "Lunch"
                    expanded = false
                }
            )
            RadioMenuItem(
                text = "Dinner",
                isSelected = selectedOption == "Dinner",
                onClick = {
                    selectedOption = "Dinner"
                    expanded = false
                }
            )
        }

       // Text(text = "Selected option: $selectedOption", fontSize = 20.sp, modifier = Modifier.padding(top = 16.dp))
    }
    return  selectedOption
}

@Composable
fun menuTaste(): String {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("") }

    Column (
        Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(8.dp)
    ){
        Button(onClick = { expanded = true }) {
            Text("Tap:$selectedOption")
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            properties = PopupProperties(focusable = true)
        ) {
            val option1="Sweet"
            val option2="Spicy"
            val option3="Salty"
            val option4="Bitter"
            val option5="Sour"
            RadioMenuItem(
                text = option1,
                isSelected = selectedOption == option1,
                onClick = {
                    selectedOption = option1
                    expanded = false
                }
            )
            RadioMenuItem(
                text = option2,
                isSelected = selectedOption == option2,
                onClick = {
                    selectedOption = option2
                    expanded = false
                }
            )
            RadioMenuItem(
                text = option3,
                isSelected = selectedOption == option3,
                onClick = {
                    selectedOption = option3
                    expanded = false
                }
            )
            RadioMenuItem(
                text = option4,
                isSelected = selectedOption == option4,
                onClick = {
                    selectedOption = option4
                    expanded = false
                }
            )

            RadioMenuItem(
                text = option5,
                isSelected = selectedOption == option5,
                onClick = {
                    selectedOption = option5
                    expanded = false
                }
            )
        }

        // Text(text = "Selected option: $selectedOption", fontSize = 20.sp, modifier = Modifier.padding(top = 16.dp))
    }
    return  selectedOption
}


@Composable
fun RadioMenuItem(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    DropdownMenuItem(
        text = {
            Row {
                RadioButton(
                    selected = isSelected,
                    onClick = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                BasicText(text)
            }
        },
        onClick = onClick
    )
}



