package com.fdegarne.look4it.techtest.core.database.challenge

import com.fdegarne.look4it.techtest.core.data.model.Challenge
import com.fdegarne.look4it.techtest.core.database.entities.ChallengeEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomChallengesDataSource @Inject constructor(
    private val challengesDao: ChallengesDao
) : ChallengesDataSource {
    override fun getChallenge(id: Long): Flow<Challenge> = challengesDao.getChallengeEntity(id).map {
        it.toChallenge()
    }

    override fun getChallenges(): Flow<List<Challenge>> = challengesDao.getChallengeEntities().map {
        it.map { challengeEntity -> challengeEntity.toChallenge() }
    }

    override suspend fun createChallenge(challenge: Challenge): Long {
        val challengeEntity = challenge.toEntity()
        return challengesDao.insertChallengeEntity(challengeEntity)
    }

    override suspend fun removeChallenge(challenge: Challenge) {
        val challengeEntity = challenge.toEntity()
        challengesDao.deleteChallengeEntity(challengeEntity)
    }

}

fun ChallengeEntity.toChallenge() = Challenge(
    id = id,
    imagePath = imagePath,
    date = date,
    locationTitle = locationTitle,
    locationId = locationId
)

fun Challenge.toEntity() = ChallengeEntity(
    id = id,
    imagePath = imagePath,
    date = date,
    locationTitle = locationTitle,
    locationId = locationId
)