package com.fdegarne.look4it.techtest.core.database.challengeofday

import com.fdegarne.look4it.techtest.core.data.model.ChallengeOfDay
import kotlinx.coroutines.flow.Flow
import java.util.Date

interface ChallengeOfDayDataSource {
    fun getChallengeOfDay(date: Date, consumed: Boolean): Flow<ChallengeOfDay>
    suspend fun createChallengeOfDay(challengeOfDay: ChallengeOfDay): Long
    suspend fun updateChallengeOfDay(challengeOfDay: ChallengeOfDay)
    suspend fun deleteChallengeOfDay(challengeOfDay: ChallengeOfDay)
}