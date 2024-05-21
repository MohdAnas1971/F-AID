package com.example.f_aid.chatBot

data class ChatData(
    val message:String,
    val role:String
)
enum class ChatRoleEnum(val role: String){
USER("user"),
    MODEL("model")
}