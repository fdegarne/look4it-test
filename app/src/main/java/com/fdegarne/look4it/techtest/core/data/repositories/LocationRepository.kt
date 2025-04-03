package com.fdegarne.look4it.techtest.core.data.repositories

import com.fdegarne.look4it.techtest.core.data.model.Location
import com.fdegarne.look4it.techtest.core.database.location.LocationDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocationRepository @Inject constructor(
    private val locationDataSource: LocationDataSource
) {
    fun getLocation(id: Long): Flow<Location> = locationDataSource.getLocation(id)
    fun getLocations(): Flow<List<Location>> = locationDataSource.getLocations()
}