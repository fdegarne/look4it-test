package com.fdegarne.look4it.techtest.core.data.repositories

import com.fdegarne.look4it.techtest.core.data.model.Challenge
import com.fdegarne.look4it.techtest.core.database.challenge.ChallengesDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChallengesRepository @Inject constructor(
    private val challengesDataSource: ChallengesDataSource
) {
    fun getChallenge(id: Long): Flow<Challenge> = challengesDataSource.getChallenge(id)

    fun getChallenges(): Flow<List<Challenge>> = challengesDataSource.getChallenges()

    suspend fun createChallenge(challenge: Challenge): Long = withContext(Dispatchers.IO) {
        challengesDataSource.createChallenge(challenge)
    }

    suspend fun removeChallenge(challenge: Challenge) = withContext(Dispatchers.IO) {
        challengesDataSource.removeChallenge(challenge)
    }
}