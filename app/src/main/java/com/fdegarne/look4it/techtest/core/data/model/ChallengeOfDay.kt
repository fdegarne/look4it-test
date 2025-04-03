package com.fdegarne.look4it.techtest.core.data.model

import java.time.LocalDate

data class ChallengeOfDay(
    val id: Long = 0,
    val date: LocalDate,
    val consumed: Boolean = false,
    val locationId: Long,
    val description: String
)