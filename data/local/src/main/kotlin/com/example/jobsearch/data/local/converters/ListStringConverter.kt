package com.example.jobsearch.data.local.converters

import androidx.room.TypeConverter
import kotlinx.serialization.json.Json

internal class ListStringConverter {
    @TypeConverter
    fun fromList(value: List<String>?): String {
        return Json.encodeToString(value ?: emptyList())
    }

    @TypeConverter
    fun toList(value: String): List<String> {
        return Json.decodeFromString(value)
    }
}