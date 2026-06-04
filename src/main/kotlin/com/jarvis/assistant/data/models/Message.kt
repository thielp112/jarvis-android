package com.jarvis.assistant.data.models

data class Message(
    val id: String = System.currentTimeMillis().toString(),
    val text: String,
    val isFromUser: Boolean,
    val timestamp: Long,
    val type: MessageType = MessageType.TEXT
)

enum class MessageType {
    TEXT,
    IMAGE,
    VOICE,
    LOCATION
}
