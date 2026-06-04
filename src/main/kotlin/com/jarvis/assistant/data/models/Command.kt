package com.jarvis.assistant.data.models

data class Command(
    val icon: String,
    val name: String,
    val description: String,
    val action: String = name.lowercase()
)
