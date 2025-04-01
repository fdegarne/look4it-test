package com.fdegarne.look4it.techtest.core.database.di

import com.fdegarne.look4it.techtest.core.database.Look4itDatabase
import com.fdegarne.look4it.techtest.core.database.challenge.ChallengesDao
import com.fdegarne.look4it.techtest.core.database.challengeofday.ChallengeOfDayDao
import com.fdegarne.look4it.techtest.core.database.location.LocationDao
import com.fdegarne.look4it.techtest.core.database.user.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {
    @Provides
    fun providesChallengesDao (
        look4itDatabase: Look4itDatabase
    ): ChallengesDao = look4itDatabase.challengesDao()

    @Provides
    fun providesChallengeOfDayDao (
        look4itDatabase: Look4itDatabase
    ): ChallengeOfDayDao = look4itDatabase.challengeOfDayDao()

    @Provides
    fun providesLocationlDao (
        look4itDatabase: Look4itDatabase
    ): LocationDao = look4itDatabase.locationDao()

    @Provides
    fun providesUserDao (
        look4itDatabase: Look4itDatabase
    ): UserDao = look4itDatabase.userDao()
}