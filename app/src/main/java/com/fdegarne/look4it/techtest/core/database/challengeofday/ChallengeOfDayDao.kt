package com.fdegarne.look4it.techtest.core.database.challengeofday

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.fdegarne.look4it.techtest.core.database.entities.ChallengeOfDayEntity
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@Dao
interface ChallengeOfDayDao {
    @Query("SELECT * FROM challenge_of_day WHERE date = :date AND :consumed = 0 LIMIT 1")
    fun getChallengeOfDayEntity(date: LocalDate, consumed: Boolean): Flow<ChallengeOfDayEntity?>

    @Query("SELECT COUNT(*) FROM challenge_of_day WHERE date = :date AND :consumed = 0 LIMIT 1")
    fun countChallengeOfDayEntity(date: LocalDate, consumed: Boolean): Int

    @Insert
    suspend fun insertChallengeOfDayEntity(challengeOfDayEntity: ChallengeOfDayEntity): Long

    @Update
    suspend fun updateChallengeOfDayEntity(challengeOfDayEntity: ChallengeOfDayEntity)

    @Delete
    suspend fun deleteChallengeOfDayEntity(challengeOfDayEntity: ChallengeOfDayEntity)
}