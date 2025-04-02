package com.fdegarne.look4it.techtest.core.data.model

import java.util.Date

data class Challenge(
    val id: Long = 0,
    val date: Date?,
    val imageId: Int? = null,
    val imagePath: String? = null,
    val locationId: Long
)