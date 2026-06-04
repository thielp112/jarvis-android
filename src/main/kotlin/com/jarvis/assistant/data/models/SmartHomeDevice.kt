package com.jarvis.assistant.data.models

data class SmartHomeDevice(
    val id: String,
    val name: String,
    val type: DeviceType,
    val isOn: Boolean,
    val brightness: Int? = null,
    val temperature: Int? = null
)

enum class DeviceType {
    LIGHT,
    THERMOSTAT,
    LOCK,
    CAMERA,
    SPEAKER,
    TV
}
