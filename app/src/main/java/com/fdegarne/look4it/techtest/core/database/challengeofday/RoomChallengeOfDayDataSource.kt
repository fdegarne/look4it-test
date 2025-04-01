package com.fdegarne.look4it.techtest.core.database.challengeofday

import com.fdegarne.look4it.techtest.core.data.model.ChallengeOfDay
import com.fdegarne.look4it.techtest.core.database.entities.ChallengeOfDayEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Date
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomChallengeOfDayDataSource @Inject constructor(
    private val challengeOfDayDao: ChallengeOfDayDao
) : ChallengeOfDayDataSource {
    override fun getChallengeOfDay(date: Date, consumed: Boolean): Flow<ChallengeOfDay> =
        challengeOfDayDao.getChallengeOfDayEntity(date, consumed).map {
            it.toChallengeOfDay()
        }

    override suspend fun createChallengeOfDay(challengeOfDay: ChallengeOfDay): Long {
        return challengeOfDayDao.insertChallengeOfDayEntity(challengeOfDay.toEntity())
    }

    override suspend fun updateChallengeOfDay(challengeOfDay: ChallengeOfDay) {
        challengeOfDayDao.updateChallengeOfDayEntity(challengeOfDay.toEntity())
    }

    override suspend fun deleteChallengeOfDay(challengeOfDay: ChallengeOfDay) {
        challengeOfDayDao.deleteChallengeOfDayEntity(challengeOfDay.toEntity())
    }
}

fun ChallengeOfDayEntity.toChallengeOfDay() = ChallengeOfDay(
    id = id,
    date = date,
    consumed = consumed
)

fun ChallengeOfDay.toEntity() = ChallengeOfDayEntity(
    id = id,
    date = date,
    consumed = consumed
)