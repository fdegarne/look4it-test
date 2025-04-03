package com.fdegarne.look4it.techtest.core.database.util

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.LocalDateTime

class TimestampConverter {
    @TypeConverter
    fun fromTimestampToDateTime(value: String?): LocalDateTime? {
        return value?.let { LocalDateTime.parse(it) }
    }

    @TypeConverter
    fun dateTimeToTimestamp(date: LocalDateTime?): String? {
        return date?.toString()
    }

    @TypeConverter
    fun fromTimestampToDate(value: String?): LocalDate? {
        return value?.let { LocalDate.parse(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: LocalDate?): String? {
        return date?.toString()
    }
}