package com.fdegarne.look4it.techtest.core.database.challenge

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.fdegarne.look4it.techtest.core.database.entities.ChallengeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ChallengesDao {
    @Query("SELECT * FROM challenges WHERE id = :id")
    fun getChallengeEntity(id: Long): Flow<ChallengeEntity>

    @Query("SELECT * FROM challenges ORDER BY date DESC")
    fun getChallengeEntities(): Flow<List<ChallengeEntity>>

    @Insert
    suspend fun insertChallengeEntity(challengeEntity: ChallengeEntity): Long

    @Insert
    fun insertAllChallengeEntities(challenges: List<ChallengeEntity>)

    @Delete
    suspend fun deleteChallengeEntity(challengeEntity: ChallengeEntity)
}