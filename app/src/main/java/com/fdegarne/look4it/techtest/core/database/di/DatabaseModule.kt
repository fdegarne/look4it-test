package com.fdegarne.look4it.techtest.core.database.di

import android.content.Context
import androidx.room.Room
import com.fdegarne.look4it.techtest.core.database.ChallengeCallback
import com.fdegarne.look4it.techtest.core.database.LocationCallback
import com.fdegarne.look4it.techtest.core.database.Look4itDatabase
import com.fdegarne.look4it.techtest.core.database.challenge.ChallengesDao
import com.fdegarne.look4it.techtest.core.database.location.LocationDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Provider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun providesLook4itDatabase(
        @ApplicationContext context: Context,
        locationProvider: Provider<LocationDao>,
        challengesProvider: Provider<ChallengesDao>
    ) : Look4itDatabase = Room.databaseBuilder(
        context,
        Look4itDatabase::class.java,
        "look4it_db"
    ).addCallback(LocationCallback(locationProvider))
        .addCallback(ChallengeCallback(challengesProvider))
        .allowMainThreadQueries()
        .build()
}