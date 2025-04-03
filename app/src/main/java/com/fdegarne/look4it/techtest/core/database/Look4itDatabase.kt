package com.fdegarne.look4it.techtest.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fdegarne.look4it.techtest.core.database.challenge.ChallengesDao
import com.fdegarne.look4it.techtest.core.database.challengeofday.ChallengeOfDayDao
import com.fdegarne.look4it.techtest.core.database.entities.ChallengeEntity
import com.fdegarne.look4it.techtest.core.database.entities.ChallengeOfDayEntity
import com.fdegarne.look4it.techtest.core.database.entities.LocationEntity
import com.fdegarne.look4it.techtest.core.database.entities.UserEntity
import com.fdegarne.look4it.techtest.core.database.location.LocationDao
import com.fdegarne.look4it.techtest.core.database.user.UserDao
import com.fdegarne.look4it.techtest.core.database.util.TimestampConverter

@Database(
    entities = [
        ChallengeEntity::class,
        ChallengeOfDayEntity::class,
        LocationEntity::class,
        UserEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(TimestampConverter::class)
abstract class Look4itDatabase : RoomDatabase() {
    abstract fun challengesDao(): ChallengesDao
    abstract fun challengeOfDayDao(): ChallengeOfDayDao
    abstract fun locationDao(): LocationDao
    abstract fun userDao(): UserDao
}