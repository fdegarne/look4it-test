package com.fdegarne.look4it.techtest.core.database.location

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fdegarne.look4it.techtest.core.database.entities.LocationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {
    @Query("SELECT * FROM locations WHERE id = :id")
    fun getLocationEntity(id: Long): Flow<LocationEntity>

    @Query("SELECT * FROM locations")
    fun getLocationEntities(): Flow<List<LocationEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllLocations(locations: List<LocationEntity>)
}