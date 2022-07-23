package com.mahmoud_bashir.madartask.data.repository.local

import androidx.lifecycle.LiveData
import com.mahmoud_bashir.madartask.data.db.UserDatabase
import com.mahmoud_bashir.madartask.data.model.UserData
import javax.inject.Inject

class UserRepository @Inject constructor(private val db : UserDatabase): IRepository {
    override suspend fun insert(userData: UserData) = db.dao().insert(userData)

    override fun getAllUserData(): LiveData<List<UserData>> = db.dao().getAllUserData()
}