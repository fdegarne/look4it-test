package com.fdegarne.look4it.techtest.core.database.location

import com.fdegarne.look4it.techtest.core.data.model.Location
import com.fdegarne.look4it.techtest.core.database.entities.LocationEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomLocationDataSource @Inject constructor(
    private val locationDao: LocationDao
) : LocationDataSource {
    override fun getLocation(id: Long): Flow<Location> = locationDao.getLocationEntity(id).map {
        it.toLocation()
    }

    override fun getLocations(): Flow<List<Location>> = locationDao.getLocationEntities().map {
        it.map { locationEntity -> locationEntity.toLocation() }
    }
}

fun LocationEntity.toLocation() = Location(
    id = id,
    title = title
)

fun Location.toEntity() = LocationEntity(
    id = id,
    title = title
)