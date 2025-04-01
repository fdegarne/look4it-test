package com.fdegarne.look4it.techtest.core.database.user

import com.fdegarne.look4it.techtest.core.data.model.User
import kotlinx.coroutines.flow.Flow

interface UserDataSource {
    fun getUser(id: Long): Flow<User>
    suspend fun createUser(user: User): Long
    suspend fun deleteUser(user: User)
}