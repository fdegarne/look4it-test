package com.fdegarne.look4it.techtest.core.database.challenge

import com.fdegarne.look4it.techtest.core.data.model.Challenge
import kotlinx.coroutines.flow.Flow

interface ChallengesDataSource {
    fun getChallenge(id: Long): Flow<Challenge>
    fun getChallenges(): Flow<List<Challenge>>
    suspend fun createChallenge(challenge: Challenge): Long
    suspend fun removeChallenge(challenge: Challenge)
}