package com.fdegarne.look4it.techtest.core.database.user

import com.fdegarne.look4it.techtest.core.data.model.User
import com.fdegarne.look4it.techtest.core.database.entities.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomUserDataSource @Inject constructor(
    private val userDao: UserDao
) : UserDataSource {
    override fun getUser(id: Long): Flow<User?> = userDao.getUserById(id).map { it?.toUser() }

    override suspend fun createUser(user: User): Long = userDao.insertUser(user.toEntity())

    override suspend fun deleteUser(user: User) {
        userDao.deleteUser(user.toEntity())
    }
}

fun UserEntity.toUser() = User(
    uid = uid,
    username = username,
    mail = mail
)

fun User.toEntity() = UserEntity(
    uid = uid,
    username = username,
    mail = mail
)