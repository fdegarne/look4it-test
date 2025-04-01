package com.fdegarne.look4it.techtest.core.database.location

import com.fdegarne.look4it.techtest.core.data.model.Location
import kotlinx.coroutines.flow.Flow

interface LocationDataSource {
    fun getLocation(id: Long): Flow<Location>
    fun getLocations(): Flow<List<Location>>
}