package com.jarvis.assistant.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jarvis.assistant.data.models.ClockDisplay
import com.jarvis.assistant.data.models.TimeZoneData
import com.jarvis.assistant.utils.ClockFormatter
import com.jarvis.assistant.utils.TimeZoneManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ClockViewModel : ViewModel() {
    private val _clockDisplays = MutableStateFlow<List<ClockDisplay>>(emptyList())
    val clockDisplays: StateFlow<List<ClockDisplay>> = _clockDisplays

    private val _selectedTimeZones = MutableStateFlow<List<TimeZoneData>>(emptyList())
    val selectedTimeZones: StateFlow<List<TimeZoneData>> = _selectedTimeZones

    private val _use24HourFormat = MutableStateFlow(true)
    val use24HourFormat: StateFlow<Boolean> = _use24HourFormat

    init {
        _selectedTimeZones.value = TimeZoneManager.getPopularTimeZones()
        startClockUpdate()
    }

    fun addTimeZone(timeZone: TimeZoneData) {
        val current = _selectedTimeZones.value.toMutableList()
        if (!current.any { it.id == timeZone.id }) {
            current.add(timeZone)
            _selectedTimeZones.value = current
        }
    }

    fun removeTimeZone(timeZone: TimeZoneData) {
        val current = _selectedTimeZones.value.toMutableList()
        current.removeAll { it.id == timeZone.id }
        _selectedTimeZones.value = current
    }

    fun toggleFormat() {
        _use24HourFormat.value = !_use24HourFormat.value
    }

    private fun startClockUpdate() {
        viewModelScope.launch {
            while (true) {
                updateClocks()
                delay(1000)
            }
        }
    }

    private fun updateClocks() {
        val displays = _selectedTimeZones.value.map { timeZone ->
            ClockFormatter.getClockDisplay(timeZone, _use24HourFormat.value)
        }
        _clockDisplays.value = displays
    }
}
