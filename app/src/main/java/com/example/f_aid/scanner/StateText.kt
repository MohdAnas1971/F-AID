package com.example.f_aid.scanner

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class StateText {

    var recognizedText: MutableState<String?> = mutableStateOf(null)
}