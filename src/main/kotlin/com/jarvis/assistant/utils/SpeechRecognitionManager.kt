package com.jarvis.assistant.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.SpeechRecognizer
import android.speech.SpeechRecognizer.ERROR_AUDIO
import android.speech.SpeechRecognizer.ERROR_CLIENT
import android.speech.SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS
import android.speech.SpeechRecognizer.ERROR_NETWORK
import android.speech.SpeechRecognizer.ERROR_NETWORK_TIMEOUT
import android.speech.SpeechRecognizer.ERROR_NO_MATCH
import android.speech.SpeechRecognizer.ERROR_RECOGNIZER_BUSY
import android.speech.SpeechRecognizer.ERROR_SERVER
import android.speech.SpeechRecognizer.RESULT_AUDIO_ERROR
import android.speech.SpeechRecognizer.RESULT_CLIENT_ERROR
import android.speech.SpeechRecognizer.RESULT_NETWORK_ERROR
import android.speech.SpeechRecognizer.RESULT_SERVER_ERROR
import android.speech.SpeechRecognizer.RESULT_NO_MATCH

class SpeechRecognitionManager(
    private val context: Context,
    private val onResult: (String) -> Unit,
    private val onError: (String) -> Unit
) : RecognitionListener {

    private val speechRecognizer: SpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(context)
    private var isListening = false

    init {
        speechRecognizer.setRecognitionListener(this)
    }

    fun startListening(language: String = "de-DE") {
        if (isListening) return

        val intent = Intent(android.speech.RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(
                android.speech.RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                android.speech.RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
            )
            putExtra(android.speech.RecognizerIntent.EXTRA_LANGUAGE, language)
            putExtra(
                android.speech.RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS,
                2000
            )
        }

        speechRecognizer.startListening(intent)
        isListening = true
    }

    fun stopListening() {
        speechRecognizer.stopListening()
        isListening = false
    }

    override fun onReadyForSpeech(params: Bundle?) {}

    override fun onBeginningOfSpeech() {}

    override fun onRmsChanged(rmsdB: Float) {}

    override fun onBufferReceived(buffer: ByteArray?) {}

    override fun onEndOfSpeech() {}

    override fun onError(error: Int) {
        isListening = false
        val errorMessage = when (error) {
            ERROR_AUDIO -> "Audio Error"
            ERROR_CLIENT -> "Client Error"
            ERROR_INSUFFICIENT_PERMISSIONS -> "Insufficient Permissions"
            ERROR_NETWORK -> "Network Error"
            ERROR_NETWORK_TIMEOUT -> "Network Timeout"
            ERROR_NO_MATCH -> "No Match"
            ERROR_RECOGNIZER_BUSY -> "Recognizer Busy"
            ERROR_SERVER -> "Server Error"
            else -> "Unknown Error"
        }
        onError(errorMessage)
    }

    override fun onResults(results: Bundle?) {
        isListening = false
        val matches = results?.getStringArrayList(android.speech.SpeechRecognizer.RESULTS_RECOGNITION)
        if (!matches.isNullOrEmpty()) {
            onResult(matches[0])
        }
    }

    override fun onPartialResults(partialResults: Bundle?) {}

    override fun onEvent(eventType: Int, params: Bundle?) {}

    fun destroy() {
        speechRecognizer.destroy()
    }
}
