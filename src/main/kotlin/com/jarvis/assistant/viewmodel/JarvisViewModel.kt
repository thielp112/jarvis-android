package com.jarvis.assistant.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jarvis.assistant.data.models.Message
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class JarvisViewModel : ViewModel() {
    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val messages: StateFlow<List<Message>> = _messages

    private val _isListening = MutableStateFlow(false)
    val isListening: StateFlow<Boolean> = _isListening

    fun addMessage(text: String, isFromUser: Boolean) {
        viewModelScope.launch {
            val newMessage = Message(
                text = text,
                isFromUser = isFromUser,
                timestamp = System.currentTimeMillis()
            )
            _messages.value = _messages.value + newMessage

            // Simulate response
            if (isFromUser) {
                val response = generateResponse(text)
                _messages.value = _messages.value + Message(
                    text = response,
                    isFromUser = false,
                    timestamp = System.currentTimeMillis()
                )
            }
        }
    }

    fun toggleListening() {
        _isListening.value = !_isListening.value
    }

    private fun generateResponse(userMessage: String): String {
        return when {
            userMessage.contains("wetter", ignoreCase = true) ->
                "🌤️ Das Wetter in deiner Stadt ist schön und warm."
            userMessage.contains("nachrichten", ignoreCase = true) ->
                "📰 Hier sind die neuesten Top-Nachrichten für dich."
            userMessage.contains("zeit", ignoreCase = true) ->
                "🕐 Die aktuelle Zeit ist ${getCurrentTime()}"
            userMessage.contains("alarm", ignoreCase = true) || userMessage.contains("wecker", ignoreCase = true) ->
                "⏰ Ich stelle dir einen Wecker für 07:00 Uhr."
            userMessage.contains("anrufen", ignoreCase = true) ->
                "📞 Welchen Kontakt möchtest du anrufen?"
            userMessage.contains("sms", ignoreCase = true) ->
                "💬 An wen möchtest du eine SMS senden?"
            userMessage.contains("smart home", ignoreCase = true) ->
                "🏠 Smart Home Geräte sind verbunden. Was möchtest du steuern?"
            else ->
                "Ich verstehe. Kannst du das bitte präzisieren? 🤔"
        }
    }

    private fun getCurrentTime(): String {
        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        return sdf.format(Date())
    }
}
