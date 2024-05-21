package com.example.f_aid.chatBot

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

class ViewModelCha : ViewModel() {

    val list by lazy {
        mutableStateListOf<ChatData>()
    }

    private val genAI by lazy {
        GenerativeModel(
            modelName = "gemini-pro",
            apiKey = "AIzaSyAcOkUgCkQKu0Aj0MKdvej-C6HhsA3lblY"
        )
    }

    fun sendMassageF(message: String) = viewModelScope.launch {

        val chat =genAI.startChat()
        list.add(ChatData(message,ChatRoleEnum.USER.role))

       val content= chat.sendMessage(content(ChatRoleEnum.USER.role) { text(message) })
           content .text?.let {
            list.add(ChatData(it,ChatRoleEnum.MODEL.role))
        }


        val response: String? = genAI.startChat().sendMessage(prompt = message).text

        Log.d("AI_ANS", response.toString())
    }

}