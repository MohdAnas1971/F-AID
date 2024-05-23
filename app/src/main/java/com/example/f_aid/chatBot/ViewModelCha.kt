package com.example.f_aid.chatBot

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.f_aid.BuildConfig
//import com.example.f_aid.BuildConfig
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

class ViewModelCha : ViewModel() {
     private val apiKey= BuildConfig.API_KEY

    val list by lazy {
        mutableStateListOf<ChatData>()
    }
    private val genAI by lazy {
        GenerativeModel(
            modelName = "gemini-pro",
            apiKey = apiKey
        )
    }
    fun sendMassageF(message: String) = viewModelScope.launch {

        val chat =genAI.startChat()
        list.add(ChatData(message,ChatRoleEnum.USER.role))

       val content= chat.sendMessage(content(ChatRoleEnum.USER.role) { text(message) }).text?.let {
            list.add(ChatData(it,ChatRoleEnum.MODEL.role))
        }
        val response: String? = genAI.startChat().sendMessage(prompt = message).text

        Log.d("AI_ANS", response.toString())
    }

}