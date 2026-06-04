package com.jarvis.assistant.utils

import com.jarvis.assistant.data.models.TimeZoneData
import java.time.ZoneId
import java.util.*

object TimeZoneManager {
    private val popularTimeZones = listOf(
        TimeZoneData(
            id = "Europe/Berlin",
            displayName = "Mitteleuropaische Zeit",
            zoneId = ZoneId.of("Europe/Berlin"),
            offsetHours = 1,
            city = "Berlin",
            country = "Deutschland"
        ),
        TimeZoneData(
            id = "Europe/London",
            displayName = "Westeuropaische Zeit",
            zoneId = ZoneId.of("Europe/London"),
            offsetHours = 0,
            city = "London",
            country = "England"
        ),
        TimeZoneData(
            id = "America/New_York",
            displayName = "Eastern Time",
            zoneId = ZoneId.of("America/New_York"),
            offsetHours = -5,
            city = "New York",
            country = "USA"
        ),
        TimeZoneData(
            id = "America/Los_Angeles",
            displayName = "Pacific Time",
            zoneId = ZoneId.of("America/Los_Angeles"),
            offsetHours = -8,
            city = "Los Angeles",
            country = "USA"
        ),
        TimeZoneData(
            id = "Asia/Tokyo",
            displayName = "Japan Standard Time",
            zoneId = ZoneId.of("Asia/Tokyo"),
            offsetHours = 9,
            city = "Tokyo",
            country = "Japan"
        ),
        TimeZoneData(
            id = "Asia/Shanghai",
            displayName = "China Standard Time",
            zoneId = ZoneId.of("Asia/Shanghai"),
            offsetHours = 8,
            city = "Shanghai",
            country = "China"
        )
    )

    fun getPopularTimeZones(): List<TimeZoneData> = popularTimeZones

    fun getTimeZoneByCity(city: String): TimeZoneData? =
        popularTimeZones.find { it.city.equals(city, ignoreCase = true) }

    fun getTimeZoneById(id: String): TimeZoneData? =
        popularTimeZones.find { it.id == id }

    fun getAllTimeZoneIds(): List<String> =
        ZoneId.getAvailableZoneIds().sorted()
}
