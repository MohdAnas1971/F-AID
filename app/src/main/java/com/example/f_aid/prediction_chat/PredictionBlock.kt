package com.example.f_aid.prediction_chat

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class PredictionBlock {
    var vegOrNon: MutableState<String> = mutableStateOf("")
    var country: MutableState<String> = mutableStateOf("")
    var teast: MutableState<String> = mutableStateOf("")
    var cost: MutableState<String> = mutableStateOf("")
    var foodFor: MutableState<String> = mutableStateOf("")
}