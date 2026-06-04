package com.jarvis.assistant.data.models

import java.time.ZoneId

data class TimeZoneData(
    val id: String,
    val displayName: String,
    val zoneId: ZoneId,
    val offsetHours: Int,
    val city: String,
    val country: String,
    val isSelected: Boolean = false
)

data class ClockDisplay(
    val timeZone: TimeZoneData,
    val currentTime: String,
    val currentDate: String,
    val dayOfWeek: String,
    val isDaytime: Boolean
)
