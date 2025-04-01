package com.fdegarne.look4it.techtest.core.data.model

import java.util.Date

data class ChallengeOfDay (
    val id: Long = 0,
    val date: Date,
    val consumed: Boolean = false
)