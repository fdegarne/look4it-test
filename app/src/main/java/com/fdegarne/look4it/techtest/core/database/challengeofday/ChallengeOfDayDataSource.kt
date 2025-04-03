package com.fdegarne.look4it.techtest.core.database.challengeofday

import com.fdegarne.look4it.techtest.core.data.model.ChallengeOfDay
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface ChallengeOfDayDataSource {
    fun getChallengeOfDay(date: LocalDate, consumed: Boolean): Flow<ChallengeOfDay?>
    fun countChallengeOfDay(date: LocalDate, consumed: Boolean): Int
    suspend fun createChallengeOfDay(challengeOfDay: ChallengeOfDay): Long
    suspend fun updateChallengeOfDay(challengeOfDay: ChallengeOfDay)
    suspend fun deleteChallengeOfDay(challengeOfDay: ChallengeOfDay)
}