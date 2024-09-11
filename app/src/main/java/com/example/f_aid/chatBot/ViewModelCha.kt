package com.example.f_aid.chatBot

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.f_aid.BuildConfig
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

class ViewModelCha : ViewModel() {
     private val apiKey= BuildConfig.API_KEY

    val list by lazy {
        mutableStateListOf<ChatData>()
    }
    val listRec by lazy {
        mutableStateListOf<ChatData>()
    }


//     val listForRec by lazy {
//        mutableStateListOf<String>()
//    }
    private val genAI by lazy {
        GenerativeModel(
            modelName = "gemini-pro",
            apiKey = apiKey
        )
    }
    fun sendMassageF(message: String,
                     check:String
    ) = viewModelScope.launch {

        val chat =genAI.startChat()
        if (check=="Bot"){
            list.add(ChatData(message,ChatRoleEnum.USER.role))


            chat.sendMessage(content(ChatRoleEnum.USER.role) { text(message) }).text?.let {
                val answer = it.replace("*", "")
                list.add(ChatData(answer,ChatRoleEnum.MODEL.role))
            }
       }
        else{
            list.add(ChatData(message,ChatRoleEnum.USER.role))
            chat.sendMessage(content(ChatRoleEnum.USER.role) { text(message) }).text?.let {
                val answer = it.replace("*", "")
                listRec.add(ChatData(answer, ChatRoleEnum.MODEL.role))
            }
        }


        val response: String? = genAI.startChat().sendMessage(prompt = message).text

        Log.d("AI_ANS", response.toString())
    }

}