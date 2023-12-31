package com.example.chatapp.data

import com.squareup.moshi.Json
import java.util.UUID

data class User(
    val id: Int,
    val image: String?,
    val owner: String,
    @Json(name="last_message")
    val lastMessage:String,
    @Json(name="last_active")
    val lastActive:String,
    @Json(name="unread_messages")
    val unreadMessages:String,
    @Json(name="is_typing")
    val isTyping:Boolean,
    @Json(name="laste_message_type")
    val lastMessageType:String
)

enum class MessageType{
    TEXT,
    FILE,
    VOICE
}