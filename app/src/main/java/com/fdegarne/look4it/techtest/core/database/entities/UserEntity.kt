package com.fdegarne.look4it.techtest.core.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val uid: Long = 0,
    val username: String,
    val mail: String
)
