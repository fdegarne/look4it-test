package com.fdegarne.look4it.techtest.core.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "challenge_of_day")
data class ChallengeOfDayEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val date: Date,
    val consumed: Boolean = false
)