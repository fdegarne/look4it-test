package com.fdegarne.look4it.techtest.core.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "challenges")
data class ChallengeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val date: LocalDateTime?,
    val imageId: Int? = null,
    val imagePath: String? = null,
    val locationId: Long
)