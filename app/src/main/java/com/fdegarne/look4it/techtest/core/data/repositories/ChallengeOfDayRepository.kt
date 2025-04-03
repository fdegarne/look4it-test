package com.fdegarne.look4it.techtest.core.data.repositories

import com.fdegarne.look4it.techtest.core.data.model.ChallengeOfDay
import com.fdegarne.look4it.techtest.core.database.challengeofday.ChallengeOfDayDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDate
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChallengeOfDayRepository @Inject constructor(
    private val challengeOfDayDataSource: ChallengeOfDayDataSource
) {
    fun getChallengeOfDay(date: LocalDate, consumed: Boolean) =
        challengeOfDayDataSource.getChallengeOfDay(date, consumed)

    fun countChallengeOfDay(date: LocalDate, consumed: Boolean) =
        challengeOfDayDataSource.countChallengeOfDay(date, consumed)

    suspend fun createChallengeOfDay(challengeOfDay: ChallengeOfDay): Long = withContext(Dispatchers.IO) {
        challengeOfDayDataSource.createChallengeOfDay(challengeOfDay)
    }

    suspend fun updateChallengeOfDay(challengeOfDay: ChallengeOfDay) = withContext(Dispatchers.IO) {
        challengeOfDayDataSource.updateChallengeOfDay(challengeOfDay)
    }

    suspend fun deleteChallengeOfDay(challengeOfDay: ChallengeOfDay) = withContext(Dispatchers.IO) {
        challengeOfDayDataSource.deleteChallengeOfDay(challengeOfDay)
    }
}