package com.mahmoud_bashir.madartask.data.repository.local

import com.mahmoud_bashir.madartask.data.db.UserDatabase
import com.mahmoud_bashir.madartask.data.model.UserData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepository @Inject constructor(private val db : UserDatabase): IRepository {
    override suspend fun insert(userData: UserData) = db.dao().insert(userData)

    override fun getAllUserData(): Flow<List<UserData>> = db.dao().getAllUserData()
}