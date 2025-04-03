package com.fdegarne.look4it.techtest.core.data.model

import androidx.compose.runtime.Immutable
import java.time.LocalDateTime

@Immutable
data class Challenge(
    val id: Long = 0,
    val date: LocalDateTime?,
    val imageId: Int? = null,
    val imagePath: String? = null,
    val locationId: Long
)