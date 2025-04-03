package com.fdegarne.look4it.techtest.core.database

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.fdegarne.look4it.techtest.R
import com.fdegarne.look4it.techtest.core.database.challenge.ChallengesDao
import com.fdegarne.look4it.techtest.core.database.entities.ChallengeEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Provider

class ChallengeCallback(
    private val provider: Provider<ChallengesDao>
) : RoomDatabase.Callback() {
    private val callBackScope = CoroutineScope(SupervisorJob())

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        callBackScope.launch {
            populateDatabaseWithChallenges()
        }
    }

    /**
     * Mock datas to work in local.
     * Goal : Fill the photos feed so we can have a base to play with.
     */
    private fun populateDatabaseWithChallenges() {
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")

        val challengeList = listOf(
            ChallengeEntity(
                date = LocalDateTime.parse("01-04-2025 10:28", formatter),
                imageId = R.drawable.train_sation,
                locationId = 0
            ),
            ChallengeEntity(
                date = LocalDateTime.parse("01-03-2025 10:28", formatter),
                imageId = R.drawable.supermarket,
                locationId = 4
            ),
            ChallengeEntity(
                date = LocalDateTime.parse("14-03-2025 10:28", formatter),
                imageId = R.drawable.cinema,
                locationId = 7
            ),
            ChallengeEntity(
                date = LocalDateTime.parse("15-03-2025 10:28", formatter),
                imageId = R.drawable.church,
                locationId = 3
            ),
            ChallengeEntity(
                date = LocalDateTime.parse("15-03-2025 10:29", formatter),
                imageId = R.drawable.italian,
                locationId = 1
            ),
            ChallengeEntity(
                date = LocalDateTime.parse("16-03-2025 10:28", formatter),
                imageId = R.drawable.train_sation,
                locationId = 0
            )
        )

        provider.get().insertAllChallengeEntities(challengeList)
    }
}