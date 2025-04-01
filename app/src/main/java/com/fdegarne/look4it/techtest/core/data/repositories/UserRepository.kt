package com.fdegarne.look4it.techtest.core.data.repositories

import com.fdegarne.look4it.techtest.core.data.model.User
import com.fdegarne.look4it.techtest.core.database.user.UserDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val userDataSource: UserDataSource
) {
    fun getUser(id: Long): Flow<User> = userDataSource.getUser(id)

    suspend fun createUser(user: User): Long = withContext(Dispatchers.IO) {
        userDataSource.createUser(user)
    }

    suspend fun deleteUser(user: User) = withContext(Dispatchers.IO) {
        userDataSource.deleteUser(user)
    }
}