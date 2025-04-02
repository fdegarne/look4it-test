package com.fdegarne.look4it.techtest.core.database

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.fdegarne.look4it.techtest.core.database.entities.LocationEntity
import com.fdegarne.look4it.techtest.core.database.location.LocationDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Provider

class LocationCallback(
    private val provider: Provider<LocationDao>
) : RoomDatabase.Callback() {
    private val callBackScope = CoroutineScope(SupervisorJob())

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        callBackScope.launch {
            populateDatabaseWithLocations()
        }
    }

    private fun populateDatabaseWithLocations() {
        val locations = listOf(
            LocationEntity(
                id = 0,
                title = "a train Station"
            ),
            LocationEntity(
                id = 1,
                title = "an italian restaurant"
            ),
            LocationEntity(
                id = 2,
                title = "a museum"
            ),
            LocationEntity(
                id = 3,
                title = "a church"
            ),
            LocationEntity(
                id = 4,
                title = "a supermarket"
            ),
            LocationEntity(
                id = 5,
                title = "a Starbucks"
            ),
            LocationEntity(
                id = 6,
                title = "a McDonald's"
            ),
            LocationEntity(
                id = 7,
                title = "a cinema"
            )
        )

        provider.get().insertAllLocations(locations)
    }
}