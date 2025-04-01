package com.fdegarne.look4it.techtest.core.data.di

import com.fdegarne.look4it.techtest.core.data.repositories.ChallengeOfDayRepository
import com.fdegarne.look4it.techtest.core.data.repositories.ChallengesRepository
import com.fdegarne.look4it.techtest.core.data.repositories.LocationRepository
import com.fdegarne.look4it.techtest.core.data.repositories.UserRepository
import com.fdegarne.look4it.techtest.core.database.challenge.ChallengesDataSource
import com.fdegarne.look4it.techtest.core.database.challenge.RoomChallengesDataSource
import com.fdegarne.look4it.techtest.core.database.challengeofday.ChallengeOfDayDataSource
import com.fdegarne.look4it.techtest.core.database.challengeofday.RoomChallengeOfDayDataSource
import com.fdegarne.look4it.techtest.core.database.location.LocationDataSource
import com.fdegarne.look4it.techtest.core.database.location.RoomLocationDataSource
import com.fdegarne.look4it.techtest.core.database.user.RoomUserDataSource
import com.fdegarne.look4it.techtest.core.database.user.UserDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindsChallengesDataSource(
        roomChallengeDataSource: RoomChallengesDataSource
    ): ChallengesDataSource

    @Binds
    abstract fun bindsChallengeOfDayDataSource(
        roomChallengeOfDayDataSource: RoomChallengeOfDayDataSource
    ): ChallengeOfDayDataSource

    @Binds
    abstract fun bindsLocationDataSource(
        roomLocationDataSource: RoomLocationDataSource
    ): LocationDataSource

    @Binds
    abstract fun bindsUserDataSource(
        roomUserDataSource: RoomUserDataSource
    ): UserDataSource

    companion object {
        @Provides
        @Singleton
        fun providesChallengesRepository(
            challengesDataSource: ChallengesDataSource
        ): ChallengesRepository = ChallengesRepository(
            challengesDataSource
        )

        @Provides
        @Singleton
        fun providesChallengeOfDayRepository(
            challengeOfDayDataSource: ChallengeOfDayDataSource
        ): ChallengeOfDayRepository = ChallengeOfDayRepository(
            challengeOfDayDataSource
        )

        @Provides
        @Singleton
        fun providesLocationRepository(
            locationDataSource: LocationDataSource
        ): LocationRepository = LocationRepository(
            locationDataSource
        )

        @Provides
        @Singleton
        fun providesUserRepository(
            userDataSource: UserDataSource
        ): UserRepository = UserRepository(
            userDataSource
        )
    }
}