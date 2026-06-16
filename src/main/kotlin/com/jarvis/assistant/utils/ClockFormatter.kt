package com.jarvis.assistant.utils

import com.jarvis.assistant.data.models.ClockDisplay
import com.jarvis.assistant.data.models.TimeZoneData
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

object ClockFormatter {
    private val timeFormatter24 = DateTimeFormatter.ofPattern("HH:mm:ss")
    private val dateFormatterDE = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    private val dayFormatterDE = DateTimeFormatter.ofPattern("EEEE", Locale("de"))

    fun getClockDisplay(
        timeZone: TimeZoneData,
        use24HourFormat: Boolean = true,
        locale: String = "de"
    ): ClockDisplay {
        val zonedDateTime = ZonedDateTime.now(timeZone.zoneId)
        val hour = zonedDateTime.hour

        val timeString = zonedDateTime.format(timeFormatter24)
        val dateString = zonedDateTime.format(dateFormatterDE)
        val dayString = zonedDateTime.format(dayFormatterDE)
        val isDaytime = hour in 6..21

        return ClockDisplay(
            timeZone = timeZone,
            currentTime = timeString,
            currentDate = dateString,
            dayOfWeek = dayString.replaceFirstChar { it.uppercaseChar() },
            isDaytime = isDaytime
        )
    }

    fun getTimeInTimeZone(timeZone: TimeZoneData, use24HourFormat: Boolean = true): String {
        val zonedDateTime = ZonedDateTime.now(timeZone.zoneId)
        return zonedDateTime.format(timeFormatter24)
    }

    fun getFormattedOffset(timeZone: TimeZoneData): String {
        val offset = timeZone.offsetHours
        val sign = if (offset >= 0) "+" else ""
        return "UTC$sign$offset"
    }

    fun getTimeDifference(fromZone: TimeZoneData, toZone: TimeZoneData): Int {
        return toZone.offsetHours - fromZone.offsetHours
    }
}
