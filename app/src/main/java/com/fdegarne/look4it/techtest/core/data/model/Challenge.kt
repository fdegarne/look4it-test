package com.fdegarne.look4it.techtest.core.data.model

import java.time.LocalDateTime
import java.util.Date

data class Challenge(
    val id: Long = 0,
    val date: LocalDateTime?,
    val imageId: Int? = null,
    val imagePath: String? = null,
    val locationId: Long
)