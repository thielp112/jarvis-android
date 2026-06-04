package com.jarvis.assistant.utils

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.*

class TextToSpeechManager(
    private val context: Context,
    private val onInitialized: () -> Unit = {},
    private val onError: (String) -> Unit = {}
) {

    private var textToSpeech: TextToSpeech? = null

    init {
        textToSpeech = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                textToSpeech?.language = Locale.GERMANY
                onInitialized()
            } else {
                onError("TextToSpeech initialization failed")
            }
        }
    }

    fun speak(text: String, queueMode: Int = TextToSpeech.QUEUE_FLUSH) {
        textToSpeech?.speak(text, queueMode, null)
    }

    fun stop() {
        textToSpeech?.stop()
    }

    fun shutdown() {
        textToSpeech?.shutdown()
    }
}
